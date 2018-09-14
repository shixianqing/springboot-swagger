package com.swagger.springbootswagger.bean;

/**
 * @Author:shixianqing
 * @Date:2018/9/1417:02
 * @Description:
 **/
public class User {

    private int userNo; //用户编号
    private String userName; //用户编号
    private int age; //用户年龄


    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }



}
