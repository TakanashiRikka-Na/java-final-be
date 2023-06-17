package com.takanashi.final_server.handler;

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
        return  Response.of(200,"success",data);
    }
}
