package org.dimhat.usercenter.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 员工账号管理器
 * 构建默认实现 公司账户名:员工账户名
 *
 * @author : zwj
 * @data : 2017/3/18
 */
public class EmployeeAccountManager {

    private static final String SPLIT = ":";

    /**
     * 构建员工真实账号
     * @param employeeAccount 员工账号
     * @param companyAccount 公司账号
     * @return 员工子账号，如com:emp
     */
    public static String buildEmployeeFullAccount(String employeeAccount, String companyAccount){
        return companyAccount+SPLIT+employeeAccount;
    }

    public static boolean isEmployeeAccount(String employeeAccount){
        if(null == employeeAccount || "".equals(employeeAccount)) return false;
        Pattern pattern = Pattern.compile("^\\w+:\\w+$");
        Matcher matcher = pattern.matcher(employeeAccount);
        return matcher.matches();
    }

    public static void main(String[] args) {
    }
}
