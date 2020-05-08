package com.jia.cglib;

import com.jia.proxy.IProducer;
import com.jia.proxy.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//模拟一个消费者
public class Client {


    public static void main(String[] args) {
        final Producer producer=new Producer();

        /**
         2.基于子类的
         涉及的类：Enhoncer
         提供者：第三方 cglib 库
         创建代理对象：使用 Enhoncer 类的 create 方法
         要求:被代理类不能是 final 类
         Enhoncer 的 create 方法，有 2 个参数：
         ①class 类型：
         指定被代理对象的指定字节码
         ②callback 类型：
         用于实现方法的增强，一般是该接口的子接口实现类：
         MethodInterceptor
         *
         *
         */

    Producer cglibproducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param o 代理对象的引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法所需的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return 和被代理对象有相同的返回值
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue=null;
                //1.获取方法执行的参数
                Float money=(Float)objects[0];

                //2.判断当前方法是不是销售
                if("saleProduct".equals(method.getName()))

                    //对于生产者来说，只能拿到八成的钱
                    returnValue=method.invoke(producer,money*(float)0.8);
                return returnValue;
            }
        });

cglibproducer.saleProduct(12000);

}
}
