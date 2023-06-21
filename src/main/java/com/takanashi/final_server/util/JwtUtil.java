package com.takanashi.final_server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.takanashi.final_server.config.JwtConfig;
import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.exception.AuthException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Date;

@Component
public class JwtUtil {
    JwtConfig jwtConfig;
    @Autowired
    public  JwtUtil (JwtConfig jwtConfig){
        this.jwtConfig=jwtConfig;
    }


    public String createToken(User user){
        Date now =new Date();
        Date expireTime= new Date(now.getTime()+this.jwtConfig.getExpiration()*1000L);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String userStr = objectMapper.writeValueAsString(user);
            return Jwts.builder()
                    .claim("UserInfo", userStr)
                    .setExpiration(expireTime)
                    .signWith(SignatureAlgorithm.HS256,this.jwtConfig.getSecret())
                    .compact();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User parseToken(String token) throws JsonProcessingException {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String userStr = claims.get("UserInfo").toString();
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(userStr,User.class);
    }

    public String  addHeader(String originToken){
        return jwtConfig.getHeader() + " " + originToken;
    }


    public String getTokenFromHeader(HttpServletRequest request) throws AuthException{
        String authorization = request.getHeader("Authorization");
        if (authorization==null||authorization.isBlank()||!authorization.startsWith("rikka")) throw new AuthException(ResponseCode.AUTH_ERROR);
        String[] split = authorization.split(" ");
        return split[1];
    }
}


