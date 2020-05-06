package com.jia.dao;

import com.jia.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//账户 dao 接口
@Repository
public interface AccountDao {
    //查询所有账户信息
    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) values(#{name},#{money})")
    //保存账户信息
    public void saveAccount(Account account);
}
