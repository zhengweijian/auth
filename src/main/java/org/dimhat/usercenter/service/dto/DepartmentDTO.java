package org.dimhat.usercenter.service.dto;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public class DepartmentDTO {

    private Long id;

    private String name;

    private List<DepartmentDTO> subDepartments;

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

    public List<DepartmentDTO> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<DepartmentDTO> subDepartments) {
        this.subDepartments = subDepartments;
    }
}
