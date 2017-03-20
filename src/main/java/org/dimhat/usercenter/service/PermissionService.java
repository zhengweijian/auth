package org.dimhat.usercenter.service;

import org.dimhat.usercenter.dao.po.PermPO;

import java.util.List;
import java.util.Set;

/**
 * @author : zwj
 * @data : 2017/3/20
 */
public interface PermissionService {

    Set<String> findPermissions(Set<Long> resourceIds); //得到资源对应的权限字符串
    List<PermPO> findMenus(Set<String> permissions); //根据用户权限得到菜单
}
