package com.takanashi.final_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.entity.HomeDTO;
import com.takanashi.final_server.mapper.HomeMapper;
import com.takanashi.final_server.service.HomeService;
import com.takanashi.final_server.util.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    HomeMapper homeMapper;
    Transform  transform;
    @Autowired
    public HomeServiceImpl(HomeMapper homeMapper,Transform transform){
        this.homeMapper=homeMapper;
        this.transform=transform;
    }
    @Override
    public HomeDTO getHomeByLeader(String leaderUserID) {
        QueryWrapper<Home> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("leader",leaderUserID);
        Home home = homeMapper.selectOne(queryWrapper);
        return transform.transform(home) ;
    }
}
