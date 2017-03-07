package org.dimhat.auth.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限表，伪删除，平台人员定义
 *
 * @author : zwj
 * @data : 2017/3/1
 */
@Entity
@Table(name="auth_perm")
public class PermPO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="name",nullable = false,length = 32)
    private String name;

    @Column(name="permission",nullable = false,unique = true,length = 64)
    private String permission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id",columnDefinition = "父权限")
    private PermPO parentPerm;

    @Column(name="is_deleted",nullable = false, columnDefinition = "是否删除")
    private Boolean deleted;

    @Column(name="depth",nullable = false,columnDefinition = "深度")
    private Integer depth;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parentPerm")
    private List<PermPO> subPerms = new ArrayList<>();

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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public PermPO getParentPerm() {
        return parentPerm;
    }

    public void setParentPerm(PermPO parentPerm) {
        this.parentPerm = parentPerm;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public List<PermPO> getSubPerms() {
        return subPerms;
    }

    public void setSubPerms(List<PermPO> subPerms) {
        this.subPerms = subPerms;
    }
}
