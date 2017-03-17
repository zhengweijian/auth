package org.dimhat.usercenter.service.bo;

import org.dimhat.usercenter.dao.po.CompanyPO;

/**
 * 根据类型不同执行不同操作
 *
 * @author : zwj
 * @data : 2017/3/1
 */
public abstract class Company {

    Long companyId;

    public Company(Long companyId) {
        if(companyId==null)
            throw new NullPointerException();
        this.companyId = companyId;
    }

    abstract CompanyPO addDepartment(String name, Long parentId);

    abstract void addEmployee();

    abstract void addRole(String name,Short type,String description);

}
