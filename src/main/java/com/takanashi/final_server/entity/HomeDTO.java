package com.takanashi.final_server.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class HomeDTO {
    private String HomeID;
    private String leader;

    public String getHomeID() {
        return HomeID;
    }


    public String getLeader() {
        return leader;
    }
}
