package org.dimhat.auth.dao;

import org.dimhat.auth.dao.po.CompanyPO;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public interface CompanyDao {

    CompanyPO getByUsername(String username);
}
