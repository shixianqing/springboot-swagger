package com.swagger.springbootswagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:shixianqing
 * @Date:2018/9/1417:02
 * @Description:
 **/
@ApiModel(description = "用户信息")
public class User {

    @ApiModelProperty(name = "userNo",value = "用户编号")
    private int userNo; //用户编号
    @ApiModelProperty(name = "userName",value = "用户名称")
    private String userName; //用户编号
    @ApiModelProperty(name = "age",value = "用户年龄")
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
