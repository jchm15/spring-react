package com.hm.springreact.webmvc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter @Setter
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 4140137442400680836L;

    private int code;
    private String message;
    private String path;
    private ZonedDateTime timestamp;

    public ErrorResponse(String path) {
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        this.path = path;
        this.timestamp = ZonedDateTime.now();
    }

    public ErrorResponse(HttpStatus status, String path) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
        this.path = path;
        this.timestamp = ZonedDateTime.now();
    }

    public ErrorResponse(String message, String path) {
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
        this.path = path;
        this.timestamp = ZonedDateTime.now();
    }

    public ErrorResponse(HttpStatus status, String message, String path) {
        this.code = status.value();
        this.message = message;
        this.path = path;
        this.timestamp = ZonedDateTime.now();
    }
}
