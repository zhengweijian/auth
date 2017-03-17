package org.dimhat.usercenter.exception.user;

/**
 * @author : zwj
 * @data : 2017/3/3
 */
public class UserFreezeException extends Exception{
    public UserFreezeException() {
    }

    public UserFreezeException(String message) {
        super(message);
    }

    public UserFreezeException(String message, Throwable cause) {
        super(message, cause);
    }
}
