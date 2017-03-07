package org.dimhat.auth.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 部门表（真删除）
 *
 * @author : zwj
 * @data : 2017/3/1
 */
@Entity
@Table(name = "u_department")
public class DepartmentPO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id",nullable = false,columnDefinition = "所属公司")
    private CompanyPO company;

    @Column(name="name",nullable = false,length = 32,columnDefinition = "部门名称")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",columnDefinition = "父部门id")
    private DepartmentPO parentDepartment;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "parentDepartment")
    private List<DepartmentPO> subDepartments = new ArrayList<>();

    public DepartmentPO getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(DepartmentPO parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public List<DepartmentPO> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<DepartmentPO> subDepartments) {
        this.subDepartments = subDepartments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyPO getCompany() {
        return company;
    }

    public void setCompany(CompanyPO company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
