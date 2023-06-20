package com.takanashi.final_server.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String Name;
    private String UserID;
    private   String HomeID;


}
