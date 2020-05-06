package com.jia.po;

public class user {
    private int userID;
    private String userName;
    private String userAddr;
    //无参构造
    public user()
    {}


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "user{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }
}
