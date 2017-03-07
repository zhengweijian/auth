package org.dimhat.auth.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 公司表，包含买家 和 卖家，不包含管理员
 *
 * @author : zwj
 * @data : 2017/3/1
 */
@Entity
@Table(name = "u_company")
public class CompanyPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 32, columnDefinition = "用户名")
    private String username;

    @Column(name = "password", nullable = false, length = 32, columnDefinition = "密码")
    private String password;

    @Column(name = "salt", nullable = false, length = 32, columnDefinition = "盐")
    private String salt;

    @Column(name = "name", nullable = true, length = 32, columnDefinition = "公司名称")
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "状态，1是正常，0是冻结")
    private Short status;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

    @Column(name="type",nullable = false,columnDefinition = "账号类型，1是管理员，2是商家，3是买家")
    private Short type;

    @Column(name="gmt_last_login",columnDefinition = "最后登录时间")
    private Date gmtLastLogin;

    @Column(name="last_login_ip",columnDefinition = "最后登录IP")
    private String lastLoginIP;

    public Date getGmtLastLogin() {
        return gmtLastLogin;
    }

    public void setGmtLastLogin(Date gmtLastLogin) {
        this.gmtLastLogin = gmtLastLogin;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
