package com.jia.controller;

import com.jia.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class userController {

    @RequestMapping("/testString")
    public String testString(Model model)
    {
        System.out.println("testString 执行了");
        //模拟从数据库中查询出用户对象，把对象存储并转发到页面上
        User user=new User();
        user.setUsername("嘉");
        user.setAge(19);
        user.setPassword("123");
        model.addAttribute("user",user);
        return "success";
    }

    //请求转发是一次请求，不用编写项目的名称
    //重定向是两次请求，要写项目的名称
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid方法执行了");
        //不会使用视图解析器了，需要手动提供完整路径
        //请求转发
     //   request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

    //重定向
//response.sendRedirect(request.getContextPath()+"/index.jsp");

        //防止中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().println("嗨你好");

    }


    //返回 ModelAndView 对象
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView()
    {
        System.out.println("testModelAndView 执行了");
        //创建 ModelAndView 对象
        ModelAndView mv=new ModelAndView();
        //模拟从数据库中查询出用户对象，把对象存储并转发到页面上
        User user=new User();
        user.setUsername("嘉");
        user.setAge(19);
        user.setPassword("123");
        //把 user 对象存储到 mv 中，它底层会把 user 存到 Request 域对象中
        mv.addObject("user",user);

        //跳转到页面
        mv.setViewName("success");
        return mv;
    }


    //使用关键字进行转发或重定向
    @RequestMapping("/testForwardOrRedirect")
    public String  testForwardOrRedirect()
    {
        System.out.println("testForwardOrRedirect 执行了");
        /*请求的转发
       return "forward:/WEB-INF/pages/success.jsp";*/
        //重定向
        return "redirect:/index.jsp";
    }

    //模拟异步请求和响应
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(User user)
    {
        System.out.println(" testAjax 执行了");
        //客户端发送 ajax 的请求，传的是 json 字符串，后端已经把 json 字符串封装到 user 对象中
        System.out.println(user);
        //做响应
        user.setUsername("哈蛤");
        user.setAge(100);
        //返回的是对象，但是前端收到的应该是json 字符串
        return user;
    }


}
