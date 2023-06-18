package com.takanashi.final_server.service;

import com.takanashi.final_server.entity.UserDTO;
import com.takanashi.final_server.exception.BaseException;
import java.util.List;

public interface UserService {
    List<UserDTO> getUserMsg() throws BaseException;

    boolean saveUser(UserDTO userDTO);
    boolean deleteUser(UserDTO userDTO);

    UserDTO getUserByUserID(String userID);
}
