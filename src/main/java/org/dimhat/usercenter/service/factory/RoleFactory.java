package org.dimhat.usercenter.service.factory;

import org.dimhat.usercenter.dao.po.RolePO;

import java.util.Date;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public class RoleFactory {

    public static RolePO createPO(){
        RolePO po = new RolePO();
        Date now = new Date();
        po.setGmtModified(now);
        po.setGmtCreate(now);
        return po;
    }
}
