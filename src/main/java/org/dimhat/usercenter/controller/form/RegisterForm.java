package org.dimhat.usercenter.controller.form;

/**
 * @author : zwj
 * @data : 2017/3/3
 */
public class RegisterForm {

    //不允许有特殊字符 [A-Za-z0-9_]
    private String username;

    private String email;

    //6
    private String password;

    //limit 2,3
    private Short type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
