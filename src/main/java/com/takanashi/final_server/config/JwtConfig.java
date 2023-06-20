package com.takanashi.final_server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    @Value("${jwt.secret}")
    private  String SECRET ;
    @Value("${jwt.header}")
    private  String Header;

    @Value("${jwt.expiration}")
    private int expiration;

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return SECRET;
    }

    public String getHeader() {
        return Header;
    }
}

