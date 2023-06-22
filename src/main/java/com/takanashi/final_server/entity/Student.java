package com.takanashi.final_server.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
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

    public Student(String HomeID, String Name, String UserID){
        this.HomeID=HomeID;
        this.UserID=UserID;
        this.Name=Name;
    }
}
