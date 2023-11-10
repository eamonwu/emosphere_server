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
        Log log = new Log();
        log.setTarget(request.getRequestURL().toString());
        log.setIpAddress(request.getRemoteAddr());
        log.setCreateDate(new Date());
        logService.save(log);
        // 返回 true，继续执行后续的请求处理
        return true;
    }
}