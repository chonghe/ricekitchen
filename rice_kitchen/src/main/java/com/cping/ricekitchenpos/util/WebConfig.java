package com.cping.ricekitchenpos.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //访问任何url都允许跨域
        /**
         * 1.与访问路径
         * 2.请求来源
         * 3.方法
         * 4.允许携带
         * 5.最大时间
         */
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080", "null")
                .allowedMethods("GET", "PUT", "POST", "OPTIONS", "DELETE")
                .allowCredentials(true) //是否允许携带信息和数据
                .maxAge(3600);  //响应最大时间
    }
}
