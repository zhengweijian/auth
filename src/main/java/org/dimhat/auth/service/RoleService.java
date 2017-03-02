package org.dimhat.auth.service;

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


}
