package org.dimhat.usercenter.service;

import org.dimhat.usercenter.service.dto.CompanyDTO;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
public interface CompanyService {

    /**
     * 用户（公司）注册
     * @param username 用户名
     * @param password 密码
     * @param type 类型，1是管理员，2是商家，3是买家
     * @return 公司id
     */
    Long register(String username,String email,String password,Short type);

    /**
     * 用户（公司）登录
     * @param username 用户名
     * @param password 密码
     * @return 公司对象
     */
    CompanyDTO login(String username, String password) ;

    /**
     * 更新公司信息
     * @param company
     */
    void update(CompanyDTO company);

    /**
     * 获取公司信息
     * @param id 公司id
     * @return 公司对象
     */
    CompanyDTO getById(Long id);

}
