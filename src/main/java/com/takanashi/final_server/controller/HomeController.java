package com.takanashi.final_server.controller;

import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class HomeController {
    HomeService homeService;
    @Autowired
    public HomeController(HomeService homeService){
        this.homeService=homeService;
    }
    @GetMapping("/home")
    public List<Home>  getHomes(){
        return homeService.getHome(null);
    }
}
