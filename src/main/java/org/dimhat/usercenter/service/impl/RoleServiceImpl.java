package org.dimhat.usercenter.service.impl;

import org.dimhat.usercenter.dao.RoleDao;
import org.dimhat.usercenter.dao.po.RolePO;
import org.dimhat.usercenter.service.RoleService;
import org.dimhat.usercenter.service.dto.RoleDTO;
import org.dimhat.usercenter.service.factory.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/3/10
 */
@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Long add(String name, String description) {
        RolePO po = RoleFactory.createPO();
        po.setName(name);
        po.setDescription(description);
        roleDao.save(po);
        return po.getId();
    }

    @Override
    public void deleteById(Long id) {
        RolePO role = roleDao.getById(id);
        if(role!=null){
            roleDao.delete(role);
        }
    }

    @Override
    public void update(Long id, String name, String description) {
        RolePO role = roleDao.getById(id);
        role.setName(name);
        role.setDescription(description);
        roleDao.update(role);
    }

    @Override
    public void updateRolePerms(Long id, List<Long> permIds) {

    }

    @Override
    public RoleDTO getById(Long id) {
        return null;
    }

    @Override
    public List<RoleDTO> listRoleWithOffice() {
        return null;
    }
}
