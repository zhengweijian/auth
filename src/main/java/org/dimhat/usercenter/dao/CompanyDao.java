package org.dimhat.usercenter.dao;

import org.dimhat.usercenter.dao.po.CompanyPO;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public interface CompanyDao extends BaseDao{

    CompanyPO getByUsername(String username);

    CompanyPO getByEmail(String email);
}
