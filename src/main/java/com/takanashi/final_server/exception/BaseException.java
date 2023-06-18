package com.takanashi.final_server.exception;

import com.takanashi.final_server.constants.ResponseCode;

public class BaseException extends RuntimeException{

    private final ResponseCode code;

    public BaseException(ResponseCode code) {
        super(code.getMessage());
        this.code = code;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
