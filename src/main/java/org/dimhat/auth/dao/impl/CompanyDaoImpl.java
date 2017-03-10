package org.dimhat.auth.dao.impl;

import org.dimhat.auth.dao.BaseDao;
import org.dimhat.auth.dao.CompanyDao;
import org.dimhat.auth.dao.po.CompanyPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
@Repository
public class CompanyDaoImpl implements CompanyDao{

    public CompanyDaoImpl() {
        System.out.println("-----------company dao!");
    }

    @Autowired
    private BaseDao<CompanyPO> baseDao;

    @Override
    public CompanyPO getByUsername(String username) {
        return baseDao.get("from CompanyPO where username = ?",new Object[]{username});
    }

    @Override
    public CompanyPO getByEmail(String email){
        return baseDao.get("from CompanyPO where email = ?",new Object[]{email});
    }
}
