package org.dimhat.usercenter.dao.impl;

import org.dimhat.usercenter.dao.CompanyDao;
import org.dimhat.usercenter.dao.po.CompanyPO;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
@Repository
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao{

    @Override
    public CompanyPO getByUsername(String username) {
        String hql = "from CompanyPO where username = ?";
        return (CompanyPO) this.get(hql,new Object[]{username});
    }

    @Override
    public CompanyPO getByEmail(String email){
        String hql = "from CompanyPO where email = ?";
        return (CompanyPO) this.get(hql,new Object[]{email});
    }
}
