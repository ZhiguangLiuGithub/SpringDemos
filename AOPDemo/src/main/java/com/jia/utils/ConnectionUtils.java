package com.jia.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//连接的工具类，它用于从数据源中获取一个连接，
//并且实现和线程的绑定
public class ConnectionUtils
{

    public ConnectionUtils()
    {}

    private ThreadLocal<Connection> tl=new ThreadLocal<>();

    //由 Spring 容器注入，需要提供 set 方法
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程的连接
     * @return
     */
    public Connection getThreadConnection()  {
        //1.先从 ThreadLocal 上获取
        Connection connection=tl.get();
        //2.判断当前线程上是否有连接
        if(connection==null)
        {
            //3.从数据源中获取连接，并且绑定到线程上，即存在 ThreadLocal 中
            try {
                connection=dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tl.set(connection);
        }
        //返回当前线程上的连接
        return connection;
    }


    public void removeConnection()
    {
        tl.remove();
    }
}