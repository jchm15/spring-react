package com.hm.springreact.exception;

public class BadRequestException extends CommonException{
    private static final long serialVersionUID = -6265824271600640380L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
