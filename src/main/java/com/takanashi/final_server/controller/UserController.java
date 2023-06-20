package com.takanashi.final_server.controller;

import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.exception.AuthException;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.handler.Response;
import com.takanashi.final_server.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public Response<Map<String, UserDTO>> register(@RequestBody UserDTO userDTO){
        if(!userService.registry(userDTO)) throw new BaseException(ResponseCode.USER_DATA_ERROR);
        userDTO.setPasswd("已加密");
        Map<String,UserDTO> userDTOMap = new HashMap<>();
        userDTOMap.put("user",userDTO);
        return Response.SuccessResponse(userDTOMap);
    };

    @PostMapping("/login")
    public Response<Map<String, String>> Login(@RequestBody UserDTO userDTO){
        String login = userService.Login(userDTO);
        if (login.isEmpty()) throw new AuthException(ResponseCode.GEN_TOKEN_FAILED);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",login);
        return Response.SuccessResponse(tokenMap);
    };


}
