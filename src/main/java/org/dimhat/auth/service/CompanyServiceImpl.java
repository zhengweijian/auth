package org.dimhat.auth.service;

import org.dimhat.auth.dao.BaseDao;
import org.dimhat.auth.dao.CompanyDao;
import org.dimhat.auth.dao.po.CompanyPO;
import org.dimhat.auth.exception.user.PasswordErrorException;
import org.dimhat.auth.exception.user.UserFreezeException;
import org.dimhat.auth.exception.user.UserNotFindException;
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

    public CompanyServiceImpl() {
        System.out.println("company生成！-----");
    }

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
    public CompanyDTO login(String username, String password) throws UserNotFindException, PasswordErrorException, UserFreezeException {
        CompanyPO companyPO = companyDao.getByUsername(username);
        if(companyPO==null){
            throw new UserNotFindException();
        }
        String salt = companyPO.getSalt();
        String md5Password = EncryptUtils.md5(password + salt);
        if(md5Password.equals(companyPO.getPassword())){
            if(companyPO.getStatus()!=1){
                throw new UserFreezeException();
            }else{//success
                CompanyDTO dto = new CompanyDTO();
                BeanUtils.copyProperties(companyPO,dto);
                return dto;
            }
        }else{
            throw new PasswordErrorException();
        }
    }

    @Override
    public void update(CompanyDTO company) {
        CompanyPO po = (CompanyPO) baseDao.get(CompanyPO.class,company.getId());
        BeanUtils.copyProperties(company,po);
        baseDao.update(po);
    }

    @Override
    public CompanyDTO getById(Long id) {
        CompanyPO po = (CompanyPO) baseDao.get(CompanyPO.class,id);
        return trans2Dto(po);
    }

    private CompanyDTO trans2Dto(CompanyPO po){
        CompanyDTO dto = new CompanyDTO();
        BeanUtils.copyProperties(po,dto);
        return dto;
    }
}
