package com.takanashi.final_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.takanashi.final_server.mapper")
public class FinalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalServerApplication.class, args);
    }

}
