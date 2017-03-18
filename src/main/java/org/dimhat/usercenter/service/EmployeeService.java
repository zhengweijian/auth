package org.dimhat.usercenter.service;

import org.dimhat.usercenter.service.dto.EmployeeDTO;
import org.springframework.beans.support.PagedListHolder;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public interface EmployeeService {

    // FIXME: 2017/3/18 使用dto好吗
    Long addEmployee(String username,String password,String name,Long departmentId);

    // FIXME: 2017/3/18 是否有权限删除？
    void deleteById(Long id);

    void update(EmployeeDTO dto);

    /**
     * 可根据部门、岗位、状态分页查找
     * @return 分页结果
     */
    PagedListHolder<EmployeeDTO> list();
}
