package com.jia.factory;

import com.jia.domain.Account;
import com.jia.service.IAccountService;
import com.jia.utils.TranscationManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class BeanFactory {

    private TranscationManager transcationManager;

    public final void setTranscationManager(TranscationManager transcationManager) {
        this.transcationManager = transcationManager;
    }


    private IAccountService accountService;
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取 Service 代理对象
     * @return
     */
    public IAccountService getAccountService()
    {
    return  (IAccountService)  Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * 添加事务支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                    {
                        Object rtValue=null;
                        try {
                        //1.开启事务
                        transcationManager.beginTranscation();
                        //2.执行操作
                      rtValue=method.invoke(accountService,args);
                        //3.提交事务
                        transcationManager.commit();
                        //4.返回结果
                        return rtValue;
                    } catch (Exception e)
                    {
                        //5.回滚操作
                        transcationManager.rollback();
                    } finally {
                        //6.释放连接
                        transcationManager.release();
                    }
                  return null;}
                });
    }
}
