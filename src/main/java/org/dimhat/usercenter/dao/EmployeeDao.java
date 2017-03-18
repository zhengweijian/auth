package org.dimhat.usercenter.dao;

import org.dimhat.usercenter.dao.po.EmployeePO;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public interface EmployeeDao extends BaseDao {

    EmployeePO getById(Long id);
}
