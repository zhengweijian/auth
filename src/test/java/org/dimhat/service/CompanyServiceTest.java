package org.dimhat.service;

import org.dimhat.auth.service.CompanyService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zwj
 * @data : 2017/3/7
 */
@ContextConfiguration(locations = "classpath:spring.xml")
@Transactional(transactionManager = "transactionManager")
@Rollback(false)
public class CompanyServiceTest  extends AbstractJUnit4SpringContextTests{

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceTest.class);

    @Autowired
    private CompanyService companyService;

    @Test
    public void testAdd(){
        Long companyId = companyService.register("test123", "123456", (short) 3);
        logger.debug("注册成功：{}",companyId);
    }

}
