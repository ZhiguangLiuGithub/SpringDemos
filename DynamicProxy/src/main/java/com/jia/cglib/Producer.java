package com.jia.cglib;

import com.jia.proxy.IProducer;

//生产者
public class Producer implements IProducer {

    //出售产品
    public void saleProduct(float money)
    {
        System.out.println("销售产品，并拿到钱："+money);
    }

    //提供售后服务
    public void afterService(float money)
    {
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
