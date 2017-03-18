package org.dimhat.usercenter.service.factory;

import org.dimhat.usercenter.dao.po.EmployeePO;

import java.util.Date;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public class EmployeeFactory {


    public static EmployeePO createPO(){
        EmployeePO po = new EmployeePO();
        Date now = new Date();
        po.setGmtCreate(now);
        po.setGmtModified(now);
        po.setDeleted(false);
        return po;
    }
}
