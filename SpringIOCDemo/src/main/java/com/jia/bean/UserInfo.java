package com.jia.bean;

public class UserInfo {
    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", person=" + person +
                '}';
    }

    private String username;
    private Person person;
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
