package com.takanashi.final_server.controller;

import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.handler.Response;
import com.takanashi.final_server.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class HomeController {
    HomeService homeService;
    @Autowired
    public HomeController(HomeService homeService){
        this.homeService=homeService;
    }
    @GetMapping("/home/leader/{leader_id}")
    public Response<HomeDTO> getHomeByLeaderID(@PathVariable("leader_id") String leaderID){
        return Response.SuccessResponse( homeService.getHomeByLeader(leaderID));
    }
    @GetMapping("/home/room/{room_id}")
    public Response<HomeDTO> getHomeByRoomID(@PathVariable("room_id") String roomID){
        return Response.SuccessResponse(homeService.getHomeByRoomID(roomID));
    }
}
