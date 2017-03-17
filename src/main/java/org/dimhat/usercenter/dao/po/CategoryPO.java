package org.dimhat.usercenter.dao.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 分类表（伪删除）
 *
 * @author : zwj
 * @data : 2017/3/1
 */
@Entity
@Table(name = "sys_category")
public class CategoryPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="name",nullable = false,length = 32,columnDefinition = "分类名称")
    private String name;

    @Column(name="depth",nullable = false,columnDefinition = "深度")
    private Integer depth;

    @Column(name="is_deleted",nullable = false,columnDefinition = "是否删除")
    private Boolean deleted;

    @Column(name="priority",nullable = false,columnDefinition = "优先级，值大靠前")
    private Integer priority;

    //冗余映射
    @Column(name="parent_id",columnDefinition = "父id",insertable = false,updatable = false)
    private Long parentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id",columnDefinition = "父分类")
    private CategoryPO parentCategory;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "parentCategory")
    private List<CategoryPO> subCategories;

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

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public CategoryPO getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryPO parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<CategoryPO> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<CategoryPO> subCategories) {
        this.subCategories = subCategories;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryPO that = (CategoryPO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (depth != null ? !depth.equals(that.depth) : that.depth != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        return parentId != null ? parentId.equals(that.parentId) : that.parentId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (depth != null ? depth.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }
}
