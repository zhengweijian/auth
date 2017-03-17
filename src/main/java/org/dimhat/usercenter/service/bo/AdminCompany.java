package org.dimhat.usercenter.service.bo;

import org.dimhat.usercenter.dao.po.CompanyPO;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public class AdminCompany extends Company {

    public AdminCompany(Long companyId) {
        super(companyId);
    }

    @Override
    CompanyPO addDepartment(String name, Long parentId) {
        throw new UnsupportedOperationException();
    }

    @Override
    void addEmployee() {
        throw new UnsupportedOperationException();
    }

    @Override
    void addRole(String name, Short type, String description) {
        throw new UnsupportedOperationException();
    }
}
