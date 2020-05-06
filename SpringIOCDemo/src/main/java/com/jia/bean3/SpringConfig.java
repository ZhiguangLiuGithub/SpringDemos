package com.jia.bean3;


import com.jia.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.jia.bean")
public class SpringConfig {

    //把当前方法的返回值作为 bean 对象存入容器中
    @Bean
public Person person()
    {
        Person person=new Person();
        return person;
    }




}
