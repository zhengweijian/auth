package org.dimhat.auth.exception.user;

/**
 * @author : zwj
 * @data : 2017/3/2
 */
public class UserNotFindException extends Exception {

    public UserNotFindException() {
    }

    public UserNotFindException(String message) {
        super(message);
    }

    public UserNotFindException(String message, Throwable cause) {
        super(message, cause);
    }
}
