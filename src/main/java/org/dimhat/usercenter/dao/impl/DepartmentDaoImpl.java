package org.dimhat.usercenter.dao.impl;

import org.dimhat.usercenter.dao.DepartmentDao;
import org.dimhat.usercenter.dao.po.DepartmentPO;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {
    @Override
    public boolean isExistSubDepartment(Long departmentId) {
        String hql="select count(*) FROM departmentPO WHERE parentDepartment.id = ?";
        Long count = count(hql, new Object[]{departmentId});
        return count!=0;
    }

    @Override
    public DepartmentPO getById(Long id) {
        return (DepartmentPO) get(DepartmentPO.class,id);
    }

    @Override
    public DepartmentPO getRootByCompanyId(Long companyId) {
        String hql = "FROM departmentPO WHERE companyId = ? and parentDepartment is null";
        return (DepartmentPO) this.get(hql, new Object[]{companyId});
    }
}
