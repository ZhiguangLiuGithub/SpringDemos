package com.jia.exception;

//自定义异常
public class sysException extends Exception{


    //存储提示信息
    private String message;
    public sysException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }






}
