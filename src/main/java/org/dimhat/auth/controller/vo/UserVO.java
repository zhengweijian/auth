package org.dimhat.auth.controller.vo;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
public class UserVO {
    private String name;

    private Integer age;

    public UserVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
