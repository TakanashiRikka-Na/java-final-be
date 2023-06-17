package com.takanashi.final_server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO  {
    private long id;
    private String Name;
    private String UserID;
    private   String HomeID;

     public String getUserID() {
          return UserID;
     }

     public String getHomeID() {
          return HomeID;
     }

     public long getId() {
          return id;
     }

     public String getName() {
          return Name;
     }
}
