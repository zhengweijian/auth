package org.dimhat.usercenter.dao;

import org.dimhat.usercenter.dao.po.RolePO;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public interface RoleDao extends BaseDao {
    RolePO getById(Long id);
}
