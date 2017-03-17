package org.dimhat.usercenter.service.bo;

import org.dimhat.usercenter.dao.po.CompanyPO;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public class SellerCompany extends Company {

    public SellerCompany(Long companyId) {
        super(companyId);
    }

    @Override
    CompanyPO addDepartment(String name, Long parentId) {
        //set companyId
        return null;
    }


    @Override
    void addEmployee() {

    }

    @Override
    void addRole(String name, Short type, String description) {

    }
}
