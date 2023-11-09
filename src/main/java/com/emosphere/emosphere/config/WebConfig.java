package com.emosphere.emosphere.config;

import com.emosphere.emosphere.domain.Log;
import com.emosphere.emosphere.interceptor.RequestLoggingInterceptor;
import com.emosphere.emosphere.service.LogService;
import com.emosphere.emosphere.service.MoodRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许特定域名跨域请求，或者使用通配符 *
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的HTTP方法
                .allowedHeaders("*") // 允许的HTTP头部
                .maxAge(3600); // 预检请求的有效期，单位秒
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，并指定拦截的路径
        registry.addInterceptor(requestLoggingInterceptor()).addPathPatterns("/**");
    }
   @Bean
   public RequestLoggingInterceptor requestLoggingInterceptor() {
       return new RequestLoggingInterceptor();
   }

}
