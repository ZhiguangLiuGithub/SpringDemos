package com.jia.Service.impl;

import com.jia.Service.IAccountService1;
import org.springframework.stereotype.Service;

//账户的业务层实现类
@Service("accountService")
public class AccountServiceImpl1 implements IAccountService1 {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
        int i=1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }


}
