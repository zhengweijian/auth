package org.dimhat.usercenter.dao.impl;

import org.dimhat.usercenter.dao.EmployeeDao;
import org.dimhat.usercenter.dao.po.EmployeePO;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {
    @Override
    public EmployeePO getById(Long id) {
        return (EmployeePO) this.get(EmployeePO.class,id);
    }
}
