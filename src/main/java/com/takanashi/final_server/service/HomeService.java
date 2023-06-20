package com.takanashi.final_server.service;

import com.takanashi.final_server.entity.HomeDTO;

public interface HomeService  {
    HomeDTO getHomeByLeader(String leaderUserID);
    HomeDTO getHomeByRoomID(String roomID);
    boolean saveHome(HomeDTO homeDTO);
}
