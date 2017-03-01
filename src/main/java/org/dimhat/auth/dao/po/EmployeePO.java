package org.dimhat.auth.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 员工表（伪删除）
 *
 * @author : zwj
 * @data : 2017/3/1
 */
@Entity
@Table(name="u_employee")
public class EmployeePO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private Long id;

    @Column(name = "username",nullable = false,unique = true,length = 32,columnDefinition = "员工用户名")
    private String username;

    @Column(name="password",nullable = false,length = 32,columnDefinition = "员工密码")
    private String password;

    @Column(name="salt",nullable = false,length = 32,columnDefinition = "密码盐")
    private String salt;

    @Column(name="name",nullable = false,columnDefinition = "员工姓名")
    private String name;

    @Column(name="sex",nullable = false,columnDefinition = "性别")
    private Boolean sex;

    @Column(name="phone",nullable = false,length = 32,columnDefinition = "手机")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id",nullable = false,columnDefinition = "所属部门")
    private DepartmentPO department;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

    @Column(name="is_deleted",nullable = false,columnDefinition = "是否被删除")
    private Boolean deleted;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DepartmentPO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentPO department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
