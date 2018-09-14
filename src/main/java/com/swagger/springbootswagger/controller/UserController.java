package com.swagger.springbootswagger.controller;

import com.swagger.springbootswagger.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @RequestMapping(value = "getUser",method = RequestMethod.POST)
    @ApiImplicitParam(name = "用户信息",required = true)
    @ApiOperation(value = "获取用户信息")
    public User getUser(@RequestBody User user){
        return user;
    }


    @RequestMapping(value = "/modifyUser/{id}",method = RequestMethod.GET)
    @ApiOperation("修改用户信息")
    @ApiImplicitParam(name = "用户id")
    public Map updUser(@PathVariable(required = true) int id){
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","修改成功");
        return map;
    }
}
