package com.takanashi.final_server.util;

import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;

public interface Transform {
     User transform(UserDTO userDTO);
     UserDTO transform(User user);

     Home transform(HomeDTO homeDTO);

     HomeDTO transform(Home home);

}


