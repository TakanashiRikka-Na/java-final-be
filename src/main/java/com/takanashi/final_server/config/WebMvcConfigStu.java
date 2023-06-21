package com.takanashi.final_server.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfigStu implements WebMvcConfigurer {
    @Resource
    StudentAuthenticationFilter studentAuthenticationFilter;
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置接口只有携带token才可以访问的路劲
        registry.addInterceptor(studentAuthenticationFilter).
                addPathPatterns("/student/**").
                excludePathPatterns(List.of("/user/login", "/user/register"));
    }
}
