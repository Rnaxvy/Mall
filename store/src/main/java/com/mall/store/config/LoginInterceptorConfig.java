package com.mall.store.config;

import com.mall.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new LoginInterceptor();
        //拦截器注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index","/login","/users/reg","/users/register","/users/in");
    }
}
