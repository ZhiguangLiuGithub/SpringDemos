package com.jia.domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//需要实现序列化接口
public class Account implements Serializable {
    private String username;
    private String password;
    private double money;
 //   private User user;
private ArrayList<User> list;
private HashMap<String,User> map;

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }

    public HashMap<String, User> getMap() {
        return map;
    }

    public void setMap(HashMap<String, User> map) {
        this.map = map;
    }

    public String getUsername() {
        return username;
    }
/*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
       */


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public void setMoney(double money) {
        this.money = money;
    }






}
