package com.takanashi.final_server.service.impl;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.mapper.UserMapper;
import com.takanashi.final_server.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserServiceImpl implements UserService {

     UserMapper userMapper ;
     @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper=userMapper;
    }
    @Override
    public List<UserDTO> getUserMsg() throws BaseException {
         List<User> users = userMapper.searchAll();
         if (users==null) throw new BaseException(ResponseCode.SERVER_ERROR);
         List<UserDTO> userDTOList = new ArrayList<>();
        for (User user: users) {
            UserDTO dto = UserDTO.
                    builder().
                    id(user.getId()).
                    HomeID(user.getHomeID()).
                    Name(user.getName()).
                    UserID(user.getUserID()).
                    build();
            userDTOList.add(dto);
        }

        return userDTOList;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
         User user= new User(userDTO.getHomeID(),userDTO.getName(),userDTO.getUserID());
         return userMapper.insert(user)==1;
    }

 }
