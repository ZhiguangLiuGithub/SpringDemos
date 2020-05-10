package com.jia.Utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("logger")
//表示当前类是个切面类
@Aspect
public class Logger {
    @Pointcut("execution(* com.jia.Service.impl.*.*(..))")
    private void pt1() {
    }

    //前置通知
    @Before("pt1()")
    public void BeforePrintLog() {
        System.out.println("前置通知：Logger 类中的 BeforePrintLog()");
    }

    @AfterReturning("pt1()")
    //后置通知
    public void AfterReturningPintLog() {
        System.out.println("后置通知：Logger 类中的 AfterPintLog()");
    }

    @AfterThrowing("pt1()")
    //异常通知
    public void AfterThrowingPrintLog() {
        System.out.println("异常通知：Logger 类中的 AfterThrowingPrintLog()");
    }

    @After("pt1()")
    //最终通知
    public void finalPrintLog() {
        System.out.println("最终通知：Logger 类中的 finalPrintLog()");
    }

   @Around("pt1()")
    //环绕通知
    public Object arroundPrintLog(ProceedingJoinPoint pjp)

    {
        Object rtValue=null;
        //明确调用业务层方法,即 切入点方法
        try {

            //得到方法执行所需的参数
            Object[] args=pjp.getArgs();

            /*
            *写在 proceed 方法前就表示它是前置通知
            System.out.println("环绕通知：Logger 类中的 arroundPrintLog() ");
            */

            rtValue=pjp.proceed(args);

            /*
            *写在 proceed 方法后就表示它是后置通知
            System.out.println("环绕通知：Logger 类中的 arroundPrintLog() ");
            */

            return rtValue;
        } catch (Throwable throwable) {


            /*
            *写在 catch 中就表示它是异常通知
            System.out.println("环绕通知：Logger 类中的 arroundPrintLog() ");
            */

            throwable.printStackTrace();
        }
        finally {
            /*
            *写在 finally 中就表示它是最终通知
            System.out.println("环绕通知：Logger 类中的 arroundPrintLog() ");
            */
        }


        return rtValue;
    }
}


