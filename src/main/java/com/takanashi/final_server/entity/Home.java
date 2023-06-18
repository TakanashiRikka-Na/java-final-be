package com.takanashi.final_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("home")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Home {
    @TableId(type = IdType.AUTO)
    private long id;

    @TableField("room_id")
    private String HomeID;
    @TableField("leader")
    private String leader;
    public Home(String leader,String HomeID){
        this.HomeID=HomeID;
        this.leader=leader;
    }
    public String getHomeIDField() {
        return "home_id";
    }

    public String getLeaderField() {
        return "leader";
    }
}
