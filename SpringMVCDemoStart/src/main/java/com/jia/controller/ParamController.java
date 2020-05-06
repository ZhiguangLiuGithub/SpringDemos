package com.jia.controller;

import com.jia.domain.Account;
import com.jia.domain.User;
import jdk.internal.cmm.SystemResourcePressureImpl;
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/param")
//请求参数绑定
public class ParamController {

    @RequestMapping("/testParam")
public String testParam(String username)
{
    System.out.println("用户名是"+username);
    System.out.println("已执行");
    return "success";

}

//请求参数绑定把数据封装到Java Bean 的类中
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account)
    {
        System.out.println("执行了");
        System.out.println(account);
        return "success" ;
    }


    //自定义类型转换器
    @RequestMapping("/saveUser")
    public String saveUser(User user)
    {
        System.out.println("执行了");
        System.out.println(user);
        return "succsee";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, ServletContext context)
    {
        System.out.println("执行了");
        System.out.println(request+","+context);
        return "succsee";
    }


}


