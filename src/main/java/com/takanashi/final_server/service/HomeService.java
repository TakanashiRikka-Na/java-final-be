package com.takanashi.final_server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.takanashi.final_server.entity.Home;
import org.w3c.dom.html.HTMLObjectElement;

import java.util.List;

public interface HomeService  {
    public List<Home> getHome(QueryWrapper<Home> wrapper);
}
