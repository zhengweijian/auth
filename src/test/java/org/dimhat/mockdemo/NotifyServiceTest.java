package org.dimhat.mockdemo;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * 对userCenter和messageCenter进行mock，只验证自身逻辑。
 * 假设依赖正确时，自身也正确。
 * @author : zwj
 * @data : 2017/3/16
 */
public class NotifyServiceTest  {

    private NotifyService notifyService;
    private UserCenter uc;
    private MessageCenter mc;

    @Before
    public void setUp(){//模拟其他模块接口
        notifyService = new NotifyService();
        uc = mock(UserCenter.class);
        notifyService.setUc(uc);
        mc = mock(MessageCenter.class);
        notifyService.setMc(mc);
    }

    @Test
    public void testSendMessage(){
        long userId = 1L;
        String email = "foo@bar";
        //设置接口调用的预期返回
        when(uc.getUser(userId)).thenReturn(createUserWithEmail(email));
        //需要测试的本模块方法
        notifyService.sendMessage(userId,"hello");
        //验证调用了其他模块方法
        verify(mc).sendEmail(eq(email),eq("hello"));
    }

    private User createUserWithEmail(String email){
        User user = new User();
        user.setEmail(email);
        return user;
    }

}
