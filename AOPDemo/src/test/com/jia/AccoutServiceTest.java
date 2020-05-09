package com.jia;

import com.jia.domain.Account;
import com.jia.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccoutServiceTest {


        @Test
        public void testFindAll() {
            //1.获取容器
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            //2.得到业务层对象
            IAccountService as = ac.getBean("accountService",IAccountService.class);
            //3.执行方法
            List<Account> accounts = as.findAllAccount();
            for(Account account : accounts){
                System.out.println(account);
            }
        }

        @Test
        public void testFindOne() {
            //1.获取容器
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            //2.得到业务层对象
            IAccountService as = ac.getBean("accountService",IAccountService.class);
            //3.执行方法
            Account account = as.findAccountById(1);
            System.out.println(account);
        }

        @Test
        public void testSave() {
            Account account = new Account();
            account.setName("aaa");
            account.setMoney(1000f);
            //1.获取容器
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            //2.得到业务层对象
            IAccountService as = ac.getBean("accountService",IAccountService.class);
            //3.执行方法
            as.saveAccount(account);
        }

        @Test
        public void testUpdate() {
            //1.获取容器
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            //2.得到业务层对象
            IAccountService as = ac.getBean("accountService",IAccountService.class);
            //3.执行方法
            Account account = as.findAccountById(1);
            account.setMoney(1000f);
            as.updateAccount(account);
        }

        @Test
        public void testDelete() {
            //1.获取容易
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            //2.得到业务层对象
            IAccountService as = ac.getBean("accountService",IAccountService.class);
            //3.执行方法
            as.deleteAccount(4);
        }

  @Autowired
 @Qualifier("proxyAccountService")
    private IAccountService as;

        @Test
    public void testTransfer()
        {
           as.transfer("aaa","bbb",400);
        }
    }

