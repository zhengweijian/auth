package org.dimhat.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.dimhat.shiro.SerializableUtils;
import org.dimhat.usercenter.dao.SessionDao;
import org.dimhat.usercenter.dao.po.SessionPO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * 带缓存
 * @author : zwj
 * @data : 2017/3/17
 */
public class MysqlCacheSessionDAO extends CachingSessionDAO {

    @Autowired
    private SessionDao sessionDao;

    @Override
    protected void doUpdate(Session session) {
        SessionPO po = sessionDao.getById(session.getId());
        po.setSession(SerializableUtils.serialize(session));
    }

    @Override
    protected void doDelete(Session session) {
        SessionPO po = sessionDao.getById(session.getId());
        if(po!=null){
            sessionDao.delete(po);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        SessionPO po = new SessionPO();
        po.setSession(SerializableUtils.serialize(session));
        return sessionDao.save(po);
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        SessionPO po = sessionDao.getById(serializable);
        Session session = SerializableUtils.deserialize(po.getSession());
        return session;
    }
}
