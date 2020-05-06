package com.jia.controller;

import com.jia.domain.User;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

//常用注解的控制器
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行了");
        System.out.println(username);
        return "success";

    }


    //获取请求体的内容
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    //PathVariable注解
    @RequestMapping("/testPathVariable/(id)")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

    //CookieValue 注解
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String CookieValue) {
        System.out.println(CookieValue);
        return "success";
    }

    //Attribute 注解
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }

    /*
    @ModelAttribute
    public User showUser(String uname)
    {
        //该方法会先执行
        System.out.println("showUser执行了");
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
*/
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map)

    {
        //该方法会先执行
        System.out.println("showUser执行了");
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    //SessionAttributes 的注解
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttribute");
//底层会存储到 request 域对象中

        model.addAttribute("msg", "美美");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelmap) {
System.out.println("getSessionAttributes");
modelmap.get("msg");
String msg=(String) modelmap.get("msg");
return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status)
    {
        System.out.println("delSessionAttributes");
        status.setComplete();
        return "success";
    }
}