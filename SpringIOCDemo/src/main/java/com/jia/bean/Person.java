package com.jia.bean;

public class Person {
    private String pname;

    public String getPname() {
        return pname;
    }
/*
    public void setPname(String pname) {
        this.pname = pname;
    }
*/



    //通过构造方法注入
    public Person(String pname) {
        this.pname = pname;
    }

    //需要一个无参构造
    public  Person()
    {}

public void SayHello()
{System.out.println("Hello Jia");}

}
