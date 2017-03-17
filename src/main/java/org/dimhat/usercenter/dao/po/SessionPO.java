package org.dimhat.usercenter.dao.po;

import java.io.Serializable;

/**
 * @author : zwj
 * @data : 2017/3/17
 */
public class SessionPO implements Serializable{

    private String id;

    private String session;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
