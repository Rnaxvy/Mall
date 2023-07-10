package com.mall.store.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

//拦截器，防止未登录就进入私密界面
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object obj=request.getSession().getAttribute("uid");
        if(obj==null){//尚未登录，给我去登录
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
