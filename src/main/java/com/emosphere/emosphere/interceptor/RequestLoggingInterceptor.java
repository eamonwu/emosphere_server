package com.emosphere.emosphere.interceptor;


import com.emosphere.emosphere.domain.Log;
import com.emosphere.emosphere.service.LogService;
import com.emosphere.emosphere.service.impl.LogServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

public class RequestLoggingInterceptor implements HandlerInterceptor {

    @Autowired
    LogService logService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前执行，可以在这里获取请求的 ID 和目标 URL
        String requestIp = getClientIp(request); // 生成请求 ID 的逻辑
        String targetUrl = request.getRequestURL().toString();

        // 输出请求的 ID 和目标 URL
        System.out.println("Request ID: " + requestIp);
        System.out.println("Target URL: " + targetUrl);
        Log log = new Log();
        log.setTarget(targetUrl);
        log.setIpAddress(requestIp);
        log.setCreateDate(new Date());
        logService.save(log);
        // 返回 true，继续执行后续的请求处理
        return true;
    }

    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }
}