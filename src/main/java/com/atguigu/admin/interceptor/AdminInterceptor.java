package com.atguigu.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 1、编写一个拦截器实现 HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //打印拦截的所有url
        String requestURI = request.getRequestURI();
        log.info("拦截的请求是" + requestURI);

        //放行
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("loginUser") != null){
            return true;
        }

        /*
            httpSession.setAttribute("msg","请登陆");
            response.sendRedirect("/login");
            问题：无法获取域对象数据，页面没用渲染
            解决办法：改用转发的方式跳转到登陆页面

            原因：
            RequestDispatcher.forward 方法的调用者与被调用者之间 共享相同的 request 对象和 response 对象 ，
            它们属于同一个访问请求和响应过程；
            而 HttpServletResponse.sendRedirect 方法调用者与被调用者使用各自的 request 对象和 response 对象，
            它们属于两个独立的访问请求和响应过程。

         */
        //转到登陆页面
        request.setAttribute("msg","请登陆");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
