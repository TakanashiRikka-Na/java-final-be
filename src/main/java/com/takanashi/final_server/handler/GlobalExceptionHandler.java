package com.takanashi.final_server.handler;

import com.takanashi.final_server.constants.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Response<T> error(Exception e) {
        log.error("[run time error : ]", e);
        return Response.of(ResponseCode.SERVER_ERROR.getCode(),ResponseCode.SERVER_ERROR.getMessage(), null);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Response<T> error(NullPointerException e) {
        log.error("[null pointer error : ]", e);
        return Response.of(ResponseCode.SERVER_ERROR.getCode(),ResponseCode.SERVER_ERROR.getMessage(), null);
    }
}
