package org.dimhat.mockdemo;

/**
 * @author : zwj
 * @data : 2017/3/16
 */
public class NotifyService {

    private UserCenter uc;
    private MessageCenter mc;

    public void sendMessage(long userId, String message) {
        String email = uc.getUser(userId).getEmail();
        mc.sendEmail(email, message);
    }

    public void setUc(UserCenter uc) {
        this.uc = uc;
    }

    public void setMc(MessageCenter mc) {
        this.mc = mc;
    }

}
