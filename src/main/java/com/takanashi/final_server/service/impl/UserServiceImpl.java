package com.takanashi.final_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.exception.AuthException;
import com.takanashi.final_server.mapper.UserMapper;
import com.takanashi.final_server.service.UserService;
import com.takanashi.final_server.util.JwtUtil;
import com.takanashi.final_server.util.PasswdUtil;
import com.takanashi.final_server.util.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   Transform transform;
    UserMapper userMapper;

    JwtUtil jwtUtil;
    @Autowired
    public UserServiceImpl(UserMapper userMapper,Transform transform,JwtUtil jwtUtil){
        this.userMapper=userMapper;
        this.transform=transform;
        this.jwtUtil=jwtUtil;
    }
    @Override
    public boolean registry(UserDTO userDTO) {
        User user = transform.transform(userDTO);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",user);
        if (userMapper.exists(queryWrapper)) throw new AuthException(ResponseCode.USER_EXIST);
        if (!PasswdUtil.isValid(user.getPasswd())) throw  new AuthException(ResponseCode.PASSWD_NOT_VALID);
        String encoded = PasswdUtil.encoded(user.getPasswd());
        user.setPasswd(encoded);
        return userMapper.insert(user)==1;
    }

    @Override
    public String Login(UserDTO userDTO) {
        User user = transform.transform(userDTO);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserID());
        if (!userMapper.exists(queryWrapper)) throw new AuthException(ResponseCode.USER_NOT_EXIST);
        User userInfo = userMapper.selectOne(queryWrapper);
        if(!PasswdUtil.check(user.getPasswd(),userInfo.getPasswd())) throw new AuthException(ResponseCode.PASSWD_DENIED);
        String token = jwtUtil.createToken(user);
        return jwtUtil.addHeader(token);
    }
}
