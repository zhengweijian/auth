package org.dimhat.auth.service;

/**
 * 部门下有员工，子部门都无法删除
 * 每个账号有个根“我的团队”无法删除和移动，只能新建子部门和重命名，
 * 默认下属“客服”、“运营”、“财务”、“仓储”部门则可以任意操作。
 *
 * @author : zwj
 * @data : 2017/3/1
 */
public interface DepartmentService {

    Long save();

    Long remove();

    void update();
}
