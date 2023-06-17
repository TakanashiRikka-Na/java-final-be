package com.takanashi.final_server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.handler.Response;
import com.takanashi.final_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/user")
    public Response<Map<String,List<UserDTO>>> getUser(){
        Map<String, List<UserDTO>> responseData = new HashMap<>();
        List<UserDTO> userDTOs= userService.getUserMsg();
        responseData.put("user",userDTOs);
        return  Response.SuccessResponse(responseData);
    }

}
