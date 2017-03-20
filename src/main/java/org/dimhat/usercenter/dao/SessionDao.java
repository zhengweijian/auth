package org.dimhat.usercenter.dao;

import org.dimhat.usercenter.dao.po.SessionPO;

import java.io.Serializable;

/**
 * @author : zwj
 * @data : 2017/3/17
 */
public interface SessionDao extends BaseDao{

    SessionPO getById(Serializable id);

}
