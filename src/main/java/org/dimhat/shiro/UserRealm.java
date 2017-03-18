package org.dimhat.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.dimhat.usercenter.account.EmployeeAccountManager;
import org.dimhat.usercenter.service.CompanyService;
import org.dimhat.usercenter.service.EmployeeService;
import org.dimhat.usercenter.service.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public class UserRealm implements Realm {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        if(authenticationToken instanceof UsernamePasswordToken)
            return true;
        return false;
    }

    //提供认证信息
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        if(!EmployeeAccountManager.isEmployeeAccount(username)){//公司账号登录
            CompanyDTO companyDTO = companyService.login(username, password);
            if(companyDTO!=null){

                return authenticationInfo;
            }
        }else{//员工账号登录

        }
        return null;
    }
}
