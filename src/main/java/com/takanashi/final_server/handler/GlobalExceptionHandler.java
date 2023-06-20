package com.takanashi.final_server.handler;

import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.exception.AuthException;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.exception.ClientException;
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
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public <T> Response<T> error(BaseException e) {
        log.error("error:", e);
        return Response.of(e.getCode().getCode(),e.getCode().getMessage(), null);
    }
    @ExceptionHandler(ClientException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> Response<T> error(ClientException e) {
        log.error("error:", e);
        return Response.of(e.getCode().getCode(),e.getCode().getMessage(), null);
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public <T> Response<T> error(AuthException e) {
        log.error("error:", e);
        return Response.of(e.getCode().getCode(),e.getCode().getMessage(), null);
    }
}
