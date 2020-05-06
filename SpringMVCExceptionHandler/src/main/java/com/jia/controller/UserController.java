package com.jia.controller;

import com.jia.exception.sysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws sysException {
        System.out.println("testException执行了");
        //模拟异常情况,假设这是 Service 层
        //先捕获异常
       try{ int a=10/0; }
catch (Exception e)
{
    //在控制台打印信息
    e.printStackTrace();
    //抛出异常信息
    throw new sysException("查询所有的用户出现错误");
}
        return "success";
    }





}
