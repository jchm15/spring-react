package com.hm.springreact.exception;

public class DuplicateEntityException extends CommonException{

    private static final long serialVersionUID = -3094039026661624526L;

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntityException(Throwable cause) {
        super(cause);
    }
}
