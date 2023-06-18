package com.takanashi.final_server.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    OK(0,"success"),
    SERVER_ERROR(1,"internal error"),

    USER_DATA_ERROR(2,"user data error");
    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
