package com.jia.test;

import Service.IAccountService1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    //1.获取容器
    ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

    //2.获取对象
    IAccountService1 as=(IAccountService1) ac.getBean("accountService");

    @Test
    public void test()
    {
        //3.执行方法,记录日志
        as.saveAccount();
    }
}
