package com.jia.service.impl;

import com.jia.dao.AccountDao;
import com.jia.domain.Account;
import com.jia.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有信息");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存信息");
        accountDao.saveAccount(account);
    }
}
