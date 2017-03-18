package org.dimhat.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.dimhat.shiro.SerializableUtils;
import org.dimhat.usercenter.dao.SessionDao;
import org.dimhat.usercenter.dao.po.SessionPO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author : zwj
 * @data : 2017/3/17
 */
public class MysqlSessionDAO implements SessionDAO{

    @Autowired
    private SessionDao sessionDao;

    @Override
    public Serializable create(Session session) {
        SessionPO po = new SessionPO();
        po.setSession(SerializableUtils.serialize(session));
        return sessionDao.save(po);
    }

    @Override
    public Session readSession(Serializable serializable) throws UnknownSessionException {
        SessionPO po = sessionDao.get(SessionPO.class, serializable);
        Session session = SerializableUtils.deserialize(po.getSession());
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        SessionPO po = sessionDao.get(SessionPO.class, session.getId());
        po.setSession(SerializableUtils.serialize(session));
    }

    @Override
    public void delete(Session session) {
        SessionPO po = sessionDao.get(SessionPO.class, session.getId());
        if(po!=null){
            sessionDao.delete(po);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
