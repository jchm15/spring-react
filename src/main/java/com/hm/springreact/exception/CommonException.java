package com.hm.springreact.exception;

public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -6051630055037974063L;

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }
}
