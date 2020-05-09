package com.jia.utils;
import java.sql.SQLException;

//和事务管理相关的工具类
//包含 开启事务、提交事务、回滚事务、释放连接
public class TranscationManager {

    //由 Spring 注入
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void beginTranscation()
    {
        try {
            //关闭自动提交
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public void commit()
    {
        try{
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务
    public void rollback()
    {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //释放连接
    public void release()
    {
        try {
            //不是真正关闭连接，只是把连接放回连接池中
            connectionUtils.getThreadConnection().close();
            //和线程解绑
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
