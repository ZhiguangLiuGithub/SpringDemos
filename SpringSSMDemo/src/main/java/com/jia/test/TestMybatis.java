package com.jia.test;

import com.jia.dao.AccountDao;
import com.jia.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatis {
    //测试查询
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in=Resources.getResourceAsStream("sqlMapConfig.xml");

        //创建 SqlSessionFactory 对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);

        //创建 SqlSession 对象
        SqlSession session=factory.openSession();

        //创建代理对象
        AccountDao dao=session.getMapper(AccountDao.class);

        //查询账户信息
        List<Account> list=dao.findAll();

        //遍历结果
        for(Account account:list)
        {
            System.out.println(account);
        }
        //释放资源
        session.close();;
        in.close();
    }

//测试保存
    @Test
    public void run2() throws IOException {
        //加载配置文件
        InputStream in=Resources.getResourceAsStream("sqlMapConfig.xml");

        //创建 SqlSessionFactory 对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);

        //创建 SqlSession 对象
        SqlSession session=factory.openSession();

        //创建代理对象
        AccountDao dao=session.getMapper(AccountDao.class);

        Account account=new Account();
        account.setName("ohh");
        account.setMoney(4000);
       dao.saveAccount(account);

       //提交事务
       session.commit();

        //释放资源
        session.close();;
        in.close();
    }
}
