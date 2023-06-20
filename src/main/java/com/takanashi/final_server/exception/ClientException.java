package com.takanashi.final_server.exception;

import com.takanashi.final_server.constants.ResponseCode;

public class ClientException extends BaseException{
    public ClientException(ResponseCode code) {
        super(code);
    }
}
