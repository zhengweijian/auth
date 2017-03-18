package org.dimhat.usercenter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : zwj
 * @data : 2017/3/10
 */
public class RegexUtils {

    /**
     * 是否是邮箱
     * @param email
     * @return 是则返回true
     */
    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 是否是手机
     * @param mobilePhone
     * @return 是则返回true
     */
    public static boolean isMobilePhone(String mobilePhone){
        if(null == mobilePhone || "".equals(mobilePhone)) return false;
        Pattern pattern = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
        Matcher matcher = pattern.matcher(mobilePhone);
        return matcher.matches();
    }


    public static void main(String[] args) {
        String email = "dimha6t@qq.com.cn";
        System.out.println(isEmail(email));
    }
}
