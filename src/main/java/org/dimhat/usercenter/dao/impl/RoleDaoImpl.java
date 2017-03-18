package org.dimhat.usercenter.dao.impl;

import org.dimhat.usercenter.dao.RoleDao;
import org.dimhat.usercenter.dao.po.RolePO;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

    @Override
    public RolePO getById(Long id){
        return (RolePO) this.get(RolePO.class,id);
    }
}
