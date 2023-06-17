package com.takanashi.final_server.service;

import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUserMsg();
}
