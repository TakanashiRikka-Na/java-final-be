package com.takanashi.final_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.takanashi.final_server.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
}
