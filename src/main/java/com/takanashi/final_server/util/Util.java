package com.takanashi.final_server.util;

import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class Util implements Transform{
    @Override
    public User transform(UserDTO userDTO) {
        return new User(userDTO.getHomeID(),userDTO.getName(),userDTO.getUserID());
    }

    @Override
    public UserDTO transform(User user) {
        return new UserDTO(user.getName(),user.getUserID(), user.getHomeID());
    }

    @Override
    public Home transform(HomeDTO homeDTO) {
        return new Home(homeDTO.getHomeID(),homeDTO.getLeader());
    }

    @Override
    public HomeDTO transform(Home home) {
        return new HomeDTO(home.getHomeID(),home.getLeader());
    }
}
