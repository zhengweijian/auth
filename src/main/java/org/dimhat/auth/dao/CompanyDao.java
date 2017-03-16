package org.dimhat.auth.dao;

import org.dimhat.auth.dao.po.CompanyPO;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public interface CompanyDao extends BaseDao{

    CompanyPO getByUsername(String username);

    CompanyPO getByEmail(String email);
}
