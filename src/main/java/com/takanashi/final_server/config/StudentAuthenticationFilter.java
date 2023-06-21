package com.takanashi.final_server.config;

import com.takanashi.final_server.constants.ResponseCode;
import com.takanashi.final_server.entity.User;
import com.takanashi.final_server.exception.AuthException;
import com.takanashi.final_server.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class StudentAuthenticationFilter implements HandlerInterceptor {
    JwtUtil jwtUtil;
    @Autowired
    public StudentAuthenticationFilter(JwtUtil jwtUtil){
        this.jwtUtil=jwtUtil;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = jwtUtil.getTokenFromHeader(request);
        User user = jwtUtil.parseToken(token);
        if(user.isTeacher()) throw  new AuthException(ResponseCode.AUTH_ERROR);
        return true;
    }
}
