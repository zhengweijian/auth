package org.dimhat.mockdemo;

/**
 * @author : zwj
 * @data : 2017/3/16
 */
public class User {

    private Long id;

    private String email;

    public String sayHi(String name,String t){
        return "hi "+name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
