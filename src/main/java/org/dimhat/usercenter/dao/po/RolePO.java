package org.dimhat.usercenter.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色表（真删除）
 *
 * @author : zwj
 * @data : 2017/3/1
 */
@Entity
@Table(name="auth_role")
public class RolePO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="name",nullable = false,columnDefinition = "角色名称")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id",columnDefinition = "角色类别")
    private CategoryPO type;

    @Column(name="description",nullable = false,columnDefinition = "角色描述")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;

    @Temporal(TemporalType.DATE)
    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",nullable = true,columnDefinition = "创建公司，null为平台创建无法删除")
    private CompanyPO creator;

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

    public CategoryPO getType() {
        return type;
    }

    public void setType(CategoryPO type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public CompanyPO getCreator() {
        return creator;
    }

    public void setCreator(CompanyPO creator) {
        this.creator = creator;
    }
}
