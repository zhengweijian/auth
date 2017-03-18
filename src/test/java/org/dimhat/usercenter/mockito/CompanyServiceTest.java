package org.dimhat.usercenter.mockito;

import org.dimhat.usercenter.SystemProperties;
import org.dimhat.usercenter.dao.CompanyDao;
import org.dimhat.usercenter.dao.po.CompanyPO;
import org.dimhat.usercenter.service.dto.CompanyDTO;
import org.dimhat.usercenter.service.impl.CompanyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author : zwj
 * @data : 2017/3/16
 */
public class CompanyServiceTest {

    private CompanyServiceImpl companyService;

    private CompanyDao companyDao;

    private SystemProperties properties;

    @Before
    public void setUp(){
        companyDao = mock(CompanyDao.class);
        properties = mock(SystemProperties.class);
        companyService = new CompanyServiceImpl();
        companyService.setCompanyDao(companyDao);
        companyService.setProperties(properties);
    }

    @Test
    public void testLoginByUsername() {
        String username = "admin";
        String password = "123456";

        CompanyPO companyPO = new CompanyPO();
        companyPO.setId(1L);
        companyPO.setPassword("");
        companyPO.setSalt("");
        when(companyDao.getByUsername(username)).thenReturn(companyPO);//伪造dao返回

        CompanyDTO companyDTO = companyService.login(username, password);
        verify(companyDao).getByUsername(eq(username));//验证dao调用
        Assert.assertEquals(companyDTO.getId(),new Long(1));
        // asserts that during the test, there are no other calls to the mock object.
        verifyNoMoreInteractions(companyDao);
    }

    @Test
    public void testLoginNotFound(){
        String username = "admin";
        String password = "123456";

        when(companyDao.getByUsername(username)).thenReturn(null);
        CompanyDTO companyDTO = companyService.login(username, password);
        Assert.assertNull(companyDTO);
    }
}
