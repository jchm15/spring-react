package com.hm.springreact.exception;

public class NotFoundException extends CommonException{
    private static final long serialVersionUID = -9220803312962256406L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
