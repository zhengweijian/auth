package org.dimhat.usercenter.service.impl;

import org.dimhat.usercenter.dao.CompanyDao;
import org.dimhat.usercenter.dao.DepartmentDao;
import org.dimhat.usercenter.dao.po.CompanyPO;
import org.dimhat.usercenter.dao.po.DepartmentPO;
import org.dimhat.usercenter.exception.BizException;
import org.dimhat.usercenter.service.DepartmentService;
import org.dimhat.usercenter.service.dto.DepartmentDTO;
import org.dimhat.usercenter.service.factory.DepartmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zwj
 * @data : 2017/3/10
 */
@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private String DEFAULT_DEPARTMENT_NAME = "我的团队";
    private String[] DEFAULT_SUB_DEPARTMENT_NAMES = {"客服","运营","财务","仓储"};

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private CompanyDao companyDao;

    @Override
    public Long addDepartment(Long companyId,Long parentDepartmentId,String name) {
        CompanyPO company = companyDao.getById(companyId);
        if(company==null){//正常使用不会发生，检查抛出异常
            throw new BizException("公司不存在：id="+companyId);
        }
        DepartmentPO parent = departmentDao.getById(parentDepartmentId);
        if(parent==null){
            throw new BizException("父部门不存在：id="+parentDepartmentId);
        }

        DepartmentPO po = DepartmentFactory.createPO();
        po.setName(name);
        po.setCompany(company);
        po.setParentDepartment(parent);
        departmentDao.save(po);
        return po.getId();
    }

    @Override
    public boolean deleteById(Long id) {

        DepartmentPO department = departmentDao.getById(id);
        if(department!=null){
            boolean existSubDepartment = departmentDao.isExistSubDepartment(id);
            if(existSubDepartment){
                return false;//正常情况下可能发生，不用抛异常
            }
            //可能幻读，即检查完后新增了一个子节点
            departmentDao.delete(department);
        }
        return true;
    }

    @Override
    public void update(Long id, String name) {
        DepartmentPO department = departmentDao.getById(id);
        department.setName(name);
        departmentDao.update(department);
    }

    @Override
    public DepartmentDTO getRootDepartment(Long companyId) {
        DepartmentPO rootDepartment = departmentDao.getRootByCompanyId(companyId);
        if(rootDepartment==null){
            rootDepartment = createDefaultRootDepartment(companyId);
        }
        return DepartmentFactory.createDTORec(rootDepartment);
    }

    //创建默认部门树
    private DepartmentPO createDefaultRootDepartment(Long companyId){
        CompanyPO company = companyDao.getById(companyId);
        if(company==null){
            throw new BizException("公司不存在：id="+companyId);
        }

        DepartmentPO po = DepartmentFactory.createPO();
        po.setCompany(company);
        po.setName(DEFAULT_DEPARTMENT_NAME);
        departmentDao.save(po);

        for (String subDepartmentName : DEFAULT_SUB_DEPARTMENT_NAMES) {
            DepartmentPO subPO = DepartmentFactory.createPO();
            po.setCompany(company);
            po.setName(subDepartmentName);
            departmentDao.save(subPO);
        }
        return po;
    }

}
