package org.dimhat.usercenter;

/**
 * @author : zwj
 * @data : 2017/3/10
 */
public class SystemProperties {

    /**
     * 邮箱验证超时时间（单位分钟）
     */
    private Integer emailValidTimeOut = 24 * 60;

    public Integer getEmailValidTimeOut() {
        return emailValidTimeOut;
    }

    public void setEmailValidTimeOut(Integer emailValidTimeOut) {
        this.emailValidTimeOut = emailValidTimeOut;
    }
}
