package org.dimhat.usercenter.dao.po;

import javax.persistence.*;

/**
 * @author : zwj
 * @data : 2017/3/7
 */
@Entity
@Table(name="auth_role_perm")
public class RolePermPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name="role_id",nullable = false,referencedColumnName = "id")
    private RolePO role;

    @ManyToOne
    @JoinColumn(name="perm_id",nullable = false,referencedColumnName = "id")
    private PermPO perm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolePO getRole() {
        return role;
    }

    public void setRole(RolePO role) {
        this.role = role;
    }

    public PermPO getPerm() {
        return perm;
    }

    public void setPerm(PermPO perm) {
        this.perm = perm;
    }
}
