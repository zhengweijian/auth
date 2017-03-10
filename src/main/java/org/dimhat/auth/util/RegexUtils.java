package org.dimhat.auth.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : zwj
 * @data : 2017/3/10
 */
public class RegexUtils {

    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }


    public static void main(String[] args) {

    }
}
