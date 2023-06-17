package com.takanashi.final_server.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @TableId(type = IdType.AUTO)
   private    long id;
    @TableField("name")
    private String Name;
    @TableField("user_id")
    private String UserID;

    @TableField("home_id")
    private String HomeID;

    public String getHomeID() {
        return HomeID;
    }

    public String getUserID() {
        return UserID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
}
