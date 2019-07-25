package com.skkj.ws.sdk.base;

/**
 * @author: yun
 * @createdOn: 2018/6/7 14:19.
 */

public class WsSdkException extends RuntimeException {

    public WsSdkException() {
        super();
    }

    public WsSdkException(String message) {
        super(message);
    }

    public WsSdkException(String message, Throwable cause) {
        super(message, cause);
    }

    public WsSdkException(Throwable cause) {
        super(cause);
    }
}
