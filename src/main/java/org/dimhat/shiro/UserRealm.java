package org.dimhat.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.dimhat.usercenter.account.EmployeeAccountManager;
import org.dimhat.usercenter.service.CompanyService;
import org.dimhat.usercenter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if(EmployeeAccountManager.isEmployeeAccount(username)){
            authorizationInfo.setRoles(employeeService.findRoles(username));
            authorizationInfo.setStringPermissions(employeeService.findPermissions(username));
        }else{
            authorizationInfo.setRoles(companyService.findRoles(username));
            authorizationInfo.setStringPermissions(companyService.findPermissions(username));
        }
        return authorizationInfo;
    }
}
