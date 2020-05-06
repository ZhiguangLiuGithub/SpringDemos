package com.jia.controller;

import com.jia.domain.Account;
import com.jia.service.AccountService;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {


    //自动注入
@Autowired
private AccountService accountService;


@RequestMapping("/findAll")
public String findAll(Model model)
{
    System.out.println("表现层：查询所有账户");

    /*如果能成功调用 service 层的方法，说明 Spring 整合 SpringMVC 成功
accountService.findAll();*/

    //调用 Service 层的方法
    List<Account> list=accountService.findAll();
    model.addAttribute("list",list);
    return "list";
}

@RequestMapping("/save")
    public void save(Account account,HttpServletResponse response,HttpServletRequest request) throws IOException {
    accountService.saveAccount(account);
    //重定向到查询结果页面
    response.sendRedirect(request.getContextPath()+"/account/findAll");
}
}
