package org.dimhat.usercenter.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 泛型dao
 *
 * @author : zwj
 * @data : 2017/3/2
 */
public interface BaseDao<T> {

    Serializable save(T o);

    void delete(T o);

    void update(T o);

    T get(Class<T> c,Serializable id);

    T get(String hql,Object[] params);

    Long count(String hql,Object[] params);

    Number sum(String hql,Object[] params);

    List<T> find(String hql,Object[] params);

    List<T> find(String hql,Object[] params,Integer page,Integer rows);
}
