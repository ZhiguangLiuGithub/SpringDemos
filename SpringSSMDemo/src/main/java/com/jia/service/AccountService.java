package com.jia.service;

import com.jia.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

//用注解的方式，把 bean 交给 IOC 容器进行管理

public interface AccountService {
        //查询所有账户信息
        public List<Account> findAll();

        //保存账户信息
        public void saveAccount(Account account);
    }

