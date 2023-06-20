package com.takanashi.final_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String userID;


    private String name;

    private String passwd;

    private boolean isTeacher;
    public UserDTO(String passwd,String name, String UserID,boolean isTeacher){
        this.userID =UserID;
        this.name=name;
        this.passwd=passwd;
        this.isTeacher=isTeacher;
    }
}
