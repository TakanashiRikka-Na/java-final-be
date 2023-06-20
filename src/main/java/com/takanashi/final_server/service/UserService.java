package com.takanashi.final_server.service;

import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;

public interface UserService {
    boolean registry(UserDTO userDTO);
    String  Login(UserDTO userDTO);
}
