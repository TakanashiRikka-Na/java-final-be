package com.takanashi.final_server.service.impl;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.mapper.UserMapper;
import com.takanashi.final_server.service.UserService;
import com.takanashi.final_server.util.Transform;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserServiceImpl implements UserService {

    Transform transform;
     UserMapper userMapper ;
     @Autowired
    public UserServiceImpl(UserMapper userMapper,Transform transform){
         this.transform=transform;
         this.userMapper=userMapper;
    }
    @Override
    public List<UserDTO> getUserMsg() throws BaseException {
         List<User> users = userMapper.searchAll();
         if (users==null) throw new BaseException(ResponseCode.SERVER_ERROR);
         List<UserDTO> userDTOList = new ArrayList<>();
        for (User user: users) {
            userDTOList.add(transform.transform(user));
        }

        return userDTOList;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
         return userMapper.insert(transform.transform(userDTO))==1;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        return true;
    }

}
