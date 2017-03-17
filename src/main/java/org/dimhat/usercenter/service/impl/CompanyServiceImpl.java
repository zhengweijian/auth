package org.dimhat.usercenter.service.impl;

import org.dimhat.usercenter.SystemProperties;
import org.dimhat.usercenter.dao.CompanyDao;
import org.dimhat.usercenter.dao.po.CompanyPO;
import org.dimhat.usercenter.exception.user.PasswordErrorException;
import org.dimhat.usercenter.exception.user.UserFreezeException;
import org.dimhat.usercenter.exception.user.UserNotFindException;
import org.dimhat.usercenter.service.CompanyService;
import org.dimhat.usercenter.service.dto.CompanyDTO;
import org.dimhat.usercenter.util.EncryptUtils;
import org.dimhat.usercenter.util.RegexUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    private SystemProperties properties;

    private CompanyDao companyDao;


    /**
     * 发送激活邮件
     * @param po 公司对象
     * @return 赋值后的公司对象
     */
    private CompanyPO sendActiveEmail(CompanyPO po){
        String token = UUID.randomUUID().toString().replaceAll("-","");//32位token
        String content="激活码【"+token+"】，请在【"+properties.getEmailTimeOut()+"】小时内激活";
        logger.info("异步队列 发送激活邮件到：{}，内容是：{}",po.getEmail(),content);
        po.setToken(token);
        DateTime exptime = new DateTime().plusHours(properties.getEmailTimeOut());
        po.setTokenExptime(exptime.toDate());
        po.setEmailActivated(false);
        return po;
    }

    /**
     * 加密密码
     * @param po 含password字段的公司
     * @return 加密设置后的公司
     */
    private CompanyPO encryptPassword(CompanyPO po){
        String password = po.getPassword();
        String salt = EncryptUtils.generateSalt();
        po.setSalt(salt);
        String md5Password = EncryptUtils.md5(password + salt);
        po.setPassword(md5Password);
        return po;
    }

    @Override
    public Long register(String username, String email,String password, Short type) {
        CompanyPO po = new CompanyPO();
        po.setUsername(username);
        po.setType(type);
        po.setStatus((short)1);
        Date now = new DateTime().toDate();
        po.setGmtCreate(now);
        po.setGmtModified(now);

        po.setEmail(email);
        po = this.sendActiveEmail(po);

        po.setPassword(password);
        po = this.encryptPassword(po);

        companyDao.save(po);
        logger.info("新用户注册成功：username={},email={},type={}",username,email,type);
        return po.getId();
    }

    private CompanyPO getCompanyByUsernameOrEmail(String username){
        if(RegexUtils.isEmail(username)){
            return companyDao.getByEmail(username);
        }else{
            return companyDao.getByUsername(username);
        }
    }

    @Override
    public CompanyDTO login(String username, String password) throws UserNotFindException, PasswordErrorException, UserFreezeException {
        CompanyPO companyPO = getCompanyByUsernameOrEmail(username);

        if(companyPO==null){
            logger.debug("can't find user by '{}'",username);
            throw new UserNotFindException();
        }
        String salt = companyPO.getSalt();
        String md5Password = EncryptUtils.md5(password + salt);
        if(md5Password.equals(companyPO.getPassword())){
            if(companyPO.getStatus()!=1){
                logger.debug("user status un normal,username {},status = {}",username,companyPO.getStatus());
                throw new UserFreezeException();
            }else{//success
                CompanyDTO dto = new CompanyDTO();
                BeanUtils.copyProperties(companyPO,dto);
                logger.debug("user login success! username:{}",username);
                return dto;
            }
        }else{
            logger.debug("user password error! username:{}",username);
            throw new PasswordErrorException();
        }
    }

    @Override
    public void update(CompanyDTO company) {
        CompanyPO po = (CompanyPO) companyDao.get(CompanyPO.class,company.getId());
        BeanUtils.copyProperties(company,po);
        companyDao.update(po);
    }

    @Override
    public CompanyDTO getById(Long id) {
        CompanyPO po = (CompanyPO) companyDao.get(CompanyPO.class,id);
        return trans2Dto(po);
    }

    private CompanyDTO trans2Dto(CompanyPO po){
        CompanyDTO dto = new CompanyDTO();
        BeanUtils.copyProperties(po,dto);
        return dto;
    }

    @Autowired
    public void setProperties(SystemProperties properties) {
        this.properties = properties;
    }

    @Autowired
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}
