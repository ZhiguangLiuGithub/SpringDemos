package com.jia.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//异常处理器
public class sysExceptionResolver implements HandlerExceptionResolver {

    //当 controller 抛异常时，会执行该方法
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //先获取异常对象
        sysException exception=null;
        if(exception instanceof sysException)
            e=(sysException)exception;
        else
            exception=new sysException("系统正在维护");

        //ModelAndView用于跳转
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("errorMsg",e.getMessage());
        //往pages.error.jsp 跳转
         modelAndView.setViewName("error");
        return modelAndView;
    }
}
