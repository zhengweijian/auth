package org.dimhat.usercenter.service;

import org.dimhat.usercenter.service.dto.RoleDTO;

import java.util.List;

/**
 * 1.新建角色基于一个分类：客服、客服主管、运营、其他、美工、财务、线下导购
 * 2.新建成功后才能修改权限
 * 3.修改权限是列出所有权限，拥有则打勾，保存后生效
 * 4.列出所有角色，其中官方的权限只能查看（全平台一份），无法修改和删除
 * 5.自定义角色删除要保证没有员工使用这一角色
 *
 * @author : zwj
 * @data : 2017/3/1
 */
public interface RoleService {

    /**
     * 新增角色
     * @param name 角色名称
     * @param description 角色备注
     * @return 角色id
     */
    Long add(String name,String description);

    void deleteById(Long id);

    void update(Long id,String name,String description);

    void updateRolePerms(Long id,List<Long> permIds);

    RoleDTO getById(Long id);

    /**
     * 列出包括官方权限在内的所有权限
     * @return 权限列表
     */
    List<RoleDTO> listRoleWithOffice();
}
