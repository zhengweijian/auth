package org.dimhat.usercenter.dao;

import org.dimhat.usercenter.dao.po.DepartmentPO;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public interface DepartmentDao extends BaseDao {

    boolean isExistSubDepartment(Long departmentId);

    DepartmentPO getById(Long id);

    DepartmentPO getRootByCompanyId(Long companyId);
}
