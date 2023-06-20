package com.takanashi.final_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private long id;
    @TableField("user_id")
    private String userID;

    @TableField("name")
    private String name;
    @TableField("passwd")
    private String passwd;
    @TableField("is_teacher")
    private boolean isTeacher;
    public User(String passwd,String name, String UserID,boolean isTeacher){
         this.userID =UserID;
         this.name=name;
         this.passwd=passwd;
         this.isTeacher=isTeacher;
    }
}
