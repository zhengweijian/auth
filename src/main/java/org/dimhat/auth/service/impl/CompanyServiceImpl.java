package org.dimhat.auth.service.impl;

import org.dimhat.auth.dao.BaseDao;
import org.dimhat.auth.dao.CompanyDao;
import org.dimhat.auth.dao.po.CompanyPO;
import org.dimhat.auth.exception.user.UserNotFindException;
import org.dimhat.auth.service.CompanyService;
import org.dimhat.auth.service.dto.CompanyDTO;
import org.dimhat.auth.util.EncryptUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private CompanyDao companyDao;

    @Override
    public Long register(String username, String password, Short type) {
        CompanyPO po = new CompanyPO();
        po.setUsername(username);

        String salt = EncryptUtils.generateSalt();
        po.setSalt(salt);
        String md5Password = EncryptUtils.md5(password + salt);
        po.setPassword(md5Password);

        po.setType(type);
        po.setStatus((short)0);

        Date now = new Date();
        po.setGmtCreate(now);
        po.setGmtModified(now);

        baseDao.save(po);
        return po.getId();
    }

    @Override
    public CompanyDTO login(String username, String password) throws UserNotFindException {
        CompanyPO companyPO = companyDao.getByUsername(username);
        if(companyPO==null){
            throw new UserNotFindException();
        }
        String salt = companyPO.getSalt();
        String md5Password = EncryptUtils.md5(password + salt);
        if(md5Password.equals(companyPO.getPassword())){
            CompanyDTO dto = new CompanyDTO();
            BeanUtils.copyProperties(companyPO,dto);
            return dto;
        }
        return null;
    }

    @Override
    public void update(CompanyDTO companyBO) {

    }

    @Override
    public CompanyDTO getById(Long id) {
        return null;
    }
}
