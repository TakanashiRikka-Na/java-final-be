package com.takanashi.final_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.entity.Home;
import com.takanashi.final_server.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Override
    public List<Home> getHome(QueryWrapper<Home> wrapper) {
        return null;
    }
}
