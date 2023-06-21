package com.takanashi.final_server.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    OK(0,"success", 200),
    SERVER_ERROR(1,"internal error", 500),

    USER_DATA_ERROR(2,"user data error", 400),
    DATA_NULL(3,"data is null", 404),
    DATA_EXIST(4,"data existed", 400),
    USER_EXIST(5,"User existed", 400),
    USER_NOT_EXIST(5,"User not existed", 400),
    PASSWD_NOT_VALID(6,"passwd is not valid",400),
    PASSWD_DENIED(7,"密码错误",401),
    GEN_TOKEN_FAILED(8,"gen token failed",401),

    AUTH_ERROR(9,"Permisson Denied",401);
    private final int code;
    private final String message;

    private final int status;

    ResponseCode(int code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
