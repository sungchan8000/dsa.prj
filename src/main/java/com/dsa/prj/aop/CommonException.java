package com.dsa.prj.aop;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends RuntimeException {

    private final int errorCode;
    private String errorMessage;

    public CommonException() {
        this.errorCode = HttpStatus.BAD_REQUEST.value();
    }

    public CommonException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage= errorMessage;
    }
}
