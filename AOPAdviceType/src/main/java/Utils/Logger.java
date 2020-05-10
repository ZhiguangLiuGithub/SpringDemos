package Utils;

import org.aspectj.lang.ProceedingJoinPoint;

/*
用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    //前置通知
    public void BeforePrintLog()
    {
        System.out.println("前置通知：Logger 类中的 BeforePrintLog()");
    }

    //后置通知
    public void AfterReturningPintLog()
    {
        System.out.println("后置通知：Logger 类中的 AfterPintLog()");
    }

    //异常通知
    public void AfterThrowingPrintLog()
    {
        System.out.println("异常通知：Logger 类中的 AfterThrowingPrintLog()");
    }

    //最终通知
    public void finalPrintLog()
    {
        System.out.println("最终通知：Logger 类中的 finalPrintLog()");
    }


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
