package com.jia.service;

import com.jia.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /*查询所有账户信息*/
    List<Account> findAllAccount();
    /*查询一个账户信息*/
    Account findAccountById(Integer accountId);
    /*保存账户信息*/
    void saveAccount(Account account);
    /*更新账户信息*/
    void updateAccount(Account account);
    /*删除账户信息*/
    void deleteAccount(Integer acccountId);
    /**
     * 转账
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money 转账金额
     */
    void transfer(String sourceName,String targetName,float money);


}
