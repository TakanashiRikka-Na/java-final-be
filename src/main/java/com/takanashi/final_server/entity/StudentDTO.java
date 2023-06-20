package com.takanashi.final_server.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class StudentDTO {
    private String Name;
    private String UserID;
    private   String HomeID;

     public String getUserID() {
          return UserID;
     }

     public String getHomeID() {
          return HomeID;
     }


     public String getName() {
          return Name;
     }
}
