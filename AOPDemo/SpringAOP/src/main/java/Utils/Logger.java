package Utils;


/*
用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    //用于打印日志，计划让其在切入点方法执行之前执行
    //（切入点 即 业务方法）
    public void printLog()
    {
        System.out.println("Logger 类中的 prinLOg 方法开始记录日志");
    }


}
