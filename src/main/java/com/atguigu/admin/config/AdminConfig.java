package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将自定义的拦截器添加到容器中
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new AdminInterceptor());
        //拦截所有路径，会拦截所有路径 包括静态资源
        interceptorRegistration.addPathPatterns("/**");
        //放行路径
        interceptorRegistration.excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
