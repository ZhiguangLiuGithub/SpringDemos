package com.jia.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器
@Controller
@RequestMapping(path = "/user")
public class helloController {


    //需要提供请求路径
    @RequestMapping(path = "/hello")
    public String sayHello()
    {System.out.println("Hello");

    //需要提供一个 success.jsp
        return "success";}


        @RequestMapping(path = "/testRequestMapping",headers = {"Acccept"})

        public String testRequestMapping()
        {
            System.out.println("测试 RequestMapping 注解");
            return "success";
        }
}
