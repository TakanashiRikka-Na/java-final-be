package com.takanashi.final_server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.handler.Response;
import com.takanashi.final_server.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Response<Map<String, List<UserDTO>>> getUser() {
        Map<String, List<UserDTO>> responseData = new HashMap<>();
        try {
            List<UserDTO> userDTOs = userService.getUserMsg();
        } catch (BaseException exception) {

        }
        List<UserDTO> userDTOs = userService.getUserMsg();
        responseData.put("user", userDTOs);
        return Response.SuccessResponse(responseData);
    }

    @PostMapping("/user")
    public Response SaveUser(@RequestBody UserDTO userDTO) throws BaseException {
       if( !userService.saveUser(userDTO)){
           throw new BaseException(ResponseCode.USER_DATA_ERROR);
       }
       return Response.SuccessResponse(null);
    }

    @DeleteMapping("/user/{user_id}")
    public Response DeleteUser(@PathVariable("user_id") String userID ){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(userID);
        if(!userService.deleteUser(userDTO)){
            throw new BaseException(ResponseCode.USER_DATA_ERROR);
        };
        return Response.SuccessResponse(null);
    }

}
