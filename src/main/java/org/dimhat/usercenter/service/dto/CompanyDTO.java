package org.dimhat.usercenter.service.dto;

/**
 * 公司业务模型
 *
 * @author : zwj
 * @data : 2017/3/1
 */
public class CompanyDTO {

    //no password,salt

    private Long id;

    private String username;

    private String name;

    private String status;

    private Short type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}
