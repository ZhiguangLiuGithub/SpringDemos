package com.jia.service.impl;

import com.jia.dao.IAccountDao;
import com.jia.domain.Account;
import com.jia.service.IAccountService;
import com.jia.utils.TranscationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */

@Service("accountService")
public class AccountServiceImpl implements IAccountService{
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    private IAccountDao accountDao;

  /*  TranscationManager transcationManager;

    public void setTranscationManager(TranscationManager transcationManager) {
        this.transcationManager = transcationManager;
    }
*/



    public IAccountDao getAccountDao() {
        return accountDao;
    }


    @Override
    public List<Account> findAllAccount() {
      /*   try {
           //1.开启事务
            transcationManager.beginTranscation();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
            transcationManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e)
        {
            //5.回滚操作
           transcationManager.rollback();
        }
        finally {
            //6.释放连接
            transcationManager.release();
        }
        return null;
        */
            return accountDao.findAllAccount();
        }


    @Override
    public Account findAccountById(Integer accountId) {
         /* try{
            //1.开启事务
            transcationManager.beginTranscation();
            //2.执行操作
           Account account=accountDao.findAccountById(accountId);
            //3.提交事务
            transcationManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e)
        {
            //5.回滚操作
            transcationManager.rollback();
        }
        finally {
            //6.释放连接
            transcationManager.release();
        }
        return null;
        */

            return accountDao.findAccountById(accountId);
    }


    @Override
    public void saveAccount(Account account) {
        /*
        try{
            //1.开启事务
            transcationManager.beginTranscation();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transcationManager.commit();
        } catch (Exception e)
        {
            //4.回滚操作
            transcationManager.rollback();
        }
        finally {
            //5.释放连接
            transcationManager.release();
        }
        */
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
/*
        try{
            //1.开启事务
            transcationManager.beginTranscation();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transcationManager.commit();
        } catch (Exception e)
        {
            //4.回滚操作
            transcationManager.rollback();
        }
        finally {
            //5.释放连接
            transcationManager.release();
        }
*/
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
/*
        try{
            //1.开启事务
            transcationManager.beginTranscation();
            //2.执行操作
            accountDao.deleteAccount(acccountId);
            //3.提交事务
            transcationManager.commit();
        } catch (Exception e)
        {
            //4.回滚操作
            transcationManager.rollback();
        }
        finally {
            //5.释放连接
            transcationManager.release();
        }
        */
        accountDao.deleteAccount(acccountId);
    }

    @Override
    public void transfer(String sourceName,String targetName,float money)
    {
/*
        try {
        //1.开启事务
        transcationManager.beginTranscation();
        */
        //2.执行操作


        //2.1 根据名称查询转入账户
        Account source = accountDao.findAccountByNames(sourceName);
        //2.2 根据名称查询转出账户
        Account target = accountDao.findAccountByNames(targetName);
        //2.3 转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4 转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5 更新转出账户
        accountDao.updateAccount(source);

       // int i = 1 / 0;

        //2.6 更新转入账户
        accountDao.updateAccount(target);
/*

        //3.提交事务
        transcationManager.commit();

    }
    catch (Exception e)
    {
        //4.回滚事务
        transcationManager.rollback();
       e.printStackTrace();
    }

    finally {
        //5.释放连接
        transcationManager.release();
    }
*/

    }
}
