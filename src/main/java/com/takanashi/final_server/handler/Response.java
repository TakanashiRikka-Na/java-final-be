package com.takanashi.final_server.handler;

import com.takanashi.final_server.constants.ResponseCode;
import lombok.Getter;

@Getter
public class Response<T> {
    private T data;
    private int code;
    private String message;
    private Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> of(int code, String message, T data) {
        return new Response<>(code, message, data);
    }
    public static <T>Response<T> SuccessResponse(T data){
        return  Response.of(ResponseCode.OK.getCode(),ResponseCode.OK.getMessage(), data);
    }

    public static <T>Response<T> ErrorResponse(ResponseCode responseCode){
        return Response.of(responseCode.getCode(),responseCode.getMessage(),null);
    }
}
