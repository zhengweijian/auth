package org.dimhat.usercenter.service;

import org.dimhat.usercenter.service.dto.DepartmentDTO;

/**
 * 部门下有员工，子部门都无法删除
 * 每个账号有个根“我的团队”无法删除和移动，只能新建子部门和重命名，
 * 默认下属“客服”、“运营”、“财务”、“仓储”部门则可以任意操作。
 *
 * @author : zwj
 * @data : 2017/3/1
 */
public interface DepartmentService {

    /**
     * 增加部门
     * @param companyId 公司id
     * @param parentDepartmentId 父部门id
     * @param departmentName 新增部门名称
     * @return 如果父公司和父部门存在则返回新增部门id，否则返回null
     */
    Long addDepartment(Long companyId,Long parentDepartmentId,String departmentName);

    /**
     * 删除部门
     * @param id 部门id
     * @return 删除成功返回true，存在子部门无法删除返回false
     */
    boolean deleteById(Long id);

    void update(Long id,String departmentName);

    DepartmentDTO getRootDepartment(Long companyId);
}
