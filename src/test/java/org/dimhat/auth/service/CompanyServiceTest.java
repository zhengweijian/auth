package org.dimhat.auth.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zwj
 * @data : 2017/3/7
 */


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
@Rollback(true)
public class CompanyServiceTest  extends AbstractTransactionalJUnit4SpringContextTests {

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceTest.class);

    @Autowired
    private CompanyService companyService;

    @Test
    public void testAdd(){
        Long companyId = companyService.register("test123","dimhat@qq.com", "123456", (short) 3);
        Assert.assertNotNull(companyId);
    }

}
