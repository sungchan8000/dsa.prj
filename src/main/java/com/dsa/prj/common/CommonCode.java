package com.dsa.prj.common;

public enum CommonCode {

    NOT_FOUND(404, "조회 결과를 찾을 수 없습니다"),
    DUPLICATED_DATA(403, "데이터가 중복입니다");

    private int code;

    private String message;

    CommonCode(int code, String message) {
        this.code   = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
