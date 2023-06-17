package com.takanashi.final_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.entity.UserDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {
    @Select("select id,home_id as HomeID,user_id as UserID ,name as Name from user")
    List<User> searchAll();
}
