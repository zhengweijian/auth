package org.dimhat.usercenter.exception.user;

/**
 * @author : zwj
 * @data : 2017/3/3
 */
public class PasswordErrorException extends Exception {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        super(message);
    }

    public PasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
