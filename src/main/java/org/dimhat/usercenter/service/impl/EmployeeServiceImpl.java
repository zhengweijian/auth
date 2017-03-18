package org.dimhat.usercenter.service.impl;

import org.dimhat.usercenter.dao.DepartmentDao;
import org.dimhat.usercenter.dao.EmployeeDao;
import org.dimhat.usercenter.dao.po.DepartmentPO;
import org.dimhat.usercenter.dao.po.EmployeePO;
import org.dimhat.usercenter.exception.BizException;
import org.dimhat.usercenter.service.EmployeeService;
import org.dimhat.usercenter.service.dto.EmployeeDTO;
import org.dimhat.usercenter.service.factory.EmployeeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Long addEmployee(String username, String password, String name, Long departmentId) {
        DepartmentPO department = departmentDao.getById(departmentId);
        if(department==null){
            throw new BizException("部门不存在：id="+departmentId);
        }

        EmployeePO po = EmployeeFactory.createPO();
        po.setName(name);
        po.setUsername(username);
        po.setPassword(password);
        po.setDepartment(department);

        employeeDao.save(po);
        return po.getId();
    }

    @Override
    public void deleteById(Long id) {
        EmployeePO employeePO = employeeDao.getById(id);
        if(employeePO!=null){
            employeeDao.delete(employeePO);
        }
    }

    @Override
    public void update(EmployeeDTO dto) {

    }

    // FIXME: 2017/3/18 hibernate分页查询
    @Override
    public PagedListHolder<EmployeeDTO> list() {
        return null;
    }
}
