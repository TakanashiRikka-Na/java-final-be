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
public class TeacherAuthenticationFilter implements HandlerInterceptor {

    private final JwtUtil jwtUtils;
    @Autowired
    public TeacherAuthenticationFilter(JwtUtil jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = jwtUtils.getTokenFromHeader(request);
        User user = jwtUtils.parseToken(token);
        if (!user.isTeacher()) throw new AuthException(ResponseCode.AUTH_ERROR);
        return true;
    }


}
