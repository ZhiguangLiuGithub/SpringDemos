package com.jia.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器
public class MyInterceptor2 implements HandlerInterceptor {
    //预处理,如果返回true 说明执行下一个拦截器；否则要执行controller 类中的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理执行了2222");
        return true;
    }

    //后处理方法，在 controller 类方法执行之后，success.jsp 执行之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理执行了2222");
    }


    //success.jsp 页面执行后，即最后执行的
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最后2222");
    }
}
