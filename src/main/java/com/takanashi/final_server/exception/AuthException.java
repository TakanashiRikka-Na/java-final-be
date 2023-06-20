package com.takanashi.final_server.exception;

import com.takanashi.final_server.constants.ResponseCode;

public class AuthException extends BaseException{
    public AuthException(ResponseCode code) {
        super(code);
    }
}
