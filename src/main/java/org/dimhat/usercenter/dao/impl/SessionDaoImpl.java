package org.dimhat.usercenter.dao.impl;


import org.dimhat.usercenter.dao.SessionDao;
import org.dimhat.usercenter.dao.po.SessionPO;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author : zwj
 * @data : 2017/3/20
 */
@Repository
public class SessionDaoImpl extends BaseDaoImpl implements SessionDao {
    @Override
    public SessionPO getById(Serializable id) {
        return (SessionPO) this.get(SessionPO.class,id);
    }
}
