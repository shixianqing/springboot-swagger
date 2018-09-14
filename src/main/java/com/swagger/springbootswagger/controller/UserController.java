package com.swagger.springbootswagger.controller;

import com.swagger.springbootswagger.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:shixianqing
 * @Date:2018/9/1417:01
 * @Description:
 **/
@RestController
@Api(value = "UserController | 测试swagger注解的控制器")
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "getUser/{id}",method = RequestMethod.GET)

    @ApiOperation(value = "获取用户信息")
    public User getUser(@RequestParam int id){
        User user = new User();
        user.setUserNo(id);
        user.setAge(12);
        user.setUserName("lisi");
        return user;
    }

    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo", value = "用户编号",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "userName", value = "用户名称", required = true,dataType = "String"),
            @ApiImplicitParam(name = "userAge",value = "用户年龄" ,required = true,dataType = "Integer")

    })
    @ApiOperation(value = "添加用户信息")
    public Map addUser(@RequestParam Integer userNo,@RequestParam String userName,@RequestParam Integer userAge){
        System.out.println("userNo="+userNo+",userName="+userName+",userAge="+userAge);
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","添加成功");
        return map;
    }


    @RequestMapping(value = "/modifyUser/{id}",method = RequestMethod.GET)
    @ApiOperation("修改用户信息")
    public Map updUser(@PathVariable(required = true) int id){
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","修改成功");
        return map;
    }
}
