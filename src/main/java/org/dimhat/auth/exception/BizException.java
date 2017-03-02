package org.dimhat.auth.exception;

/**
 * 业务异常
 * @author : zwj
 * @data : 2017/3/2
 */
public class BizException extends RuntimeException {

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
