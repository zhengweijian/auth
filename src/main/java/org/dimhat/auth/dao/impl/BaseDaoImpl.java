package org.dimhat.auth.dao.impl;

import org.dimhat.auth.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    protected void setParameters(Query q,Object[] params){
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                q.setParameter(i, params[i]);
            }
        }
    }

    @Override
    public Serializable save(Object o) {
        return this.getCurrentSession().save(o);
    }

    @Override
    public void delete(Object o) {
        this.getCurrentSession().delete(o);
    }

    @Override
    public void update(Object o) {
        this.getCurrentSession().update(o);
    }

    @Override
    public Object get(Class c, Serializable id) {
        return this.getCurrentSession().get(c,id);
    }

    @Override
    public Object get(String hql, Object[] params) {
        List list = this.find(hql, params);
        if(list == null || list.size()==0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public Long count(String hql, Object[] params) {
        Query q = this.getCurrentSession().createQuery(hql);
        this.setParameters(q,params);
        return (Long) q.uniqueResult();
    }

    @Override
    public Number sum(String hql, Object[] params) {
        return null;
    }

    @Override
    public List find(String hql, Object[] params) {
        Query query = this.getCurrentSession().createQuery(hql);
        this.setParameters(query,params);
        return query.list();
    }

    @Override
    public List find(String hql, Object[] params, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);

        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }
}
