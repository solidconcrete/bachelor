package com.bachelor.bachelor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader("tenant").isEmpty()) {
            throw new IllegalArgumentException("tenant must be specified");
        }
        TenantProvider.setCurrentDb(request.getHeader("tenant"));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
