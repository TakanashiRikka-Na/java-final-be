package com.takanashi.final_server.controller;

import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.exception.BaseException;
import com.takanashi.final_server.handler.Response;
import com.takanashi.final_server.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    HomeService homeService;
    @Autowired
    public HomeController(HomeService homeService){
        this.homeService=homeService;
    }
    @GetMapping("/home/{leader_id}")
    public Response<HomeDTO> getHomeByLeaderID(@PathVariable("leader_id") String leaderID){
        HomeDTO homeByLeader = homeService.getHomeByLeader(leaderID);
        if (homeByLeader==null) throw new BaseException(ResponseCode.SERVER_ERROR);
        return Response.SuccessResponse(homeByLeader);
    }

}
