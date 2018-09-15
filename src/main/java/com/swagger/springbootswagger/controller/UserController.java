package com.swagger.springbootswagger.controller;

import com.swagger.springbootswagger.bean.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:shixianqing
 * @Date:2018/9/1417:01
 * @Description:
 **/
@RestController
@Api(tags = "UserController | 测试swagger注解的控制器")
@RequestMapping(value = "/user")
public class UserController {

    private static final Map RESPONSE = new HashMap();

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户编号",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "用户名称",paramType = "query")
    })
    public User getUser(@RequestParam(required = false) int id,@RequestParam(required = false) String name){
        User user = new User();
        user.setUserNo(id);
        user.setAge(12);
        user.setUserName("lisi");
        return user;
    }

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "用户信息",dataType = "User",paramType = "body"),
    })
    public Map addUser(@RequestBody User user){
        System.out.println(user.toString());
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","添加成功");
        return map;
    }


    @RequestMapping(value = "/modifyUser/{userNo}",method = RequestMethod.GET)
    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo",value = "用户编号",paramType = "path")
    })
    public Map updUser(@PathVariable(required = true) int userNo){
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","修改成功");
        return map;
    }

    @RequestMapping(value = "/upload",headers = "Content-type=multipart/form-data",method = RequestMethod.POST)
    public void upload(@ApiParam(name = "file",value = "上传文件") MultipartFile file){

    }

    @RequestMapping(value = "addUserForPost",method = RequestMethod.POST,headers = "Content-Type=application/x-www-form-urlencoded")
    @ApiOperation(value = "表单形式添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名称",paramType = "form",required = true),
            @ApiImplicitParam(name = "userAge",value = "用户年龄",paramType = "form",required = true)
    })
    public Map addUser(HttpServletRequest request,String userName, Integer userAge){

        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();

            System.out.println(name+"==="+request.getHeader(name));
        }
        System.out.println("userName="+userName+",userAge="+userAge);
        RESPONSE.put("code",200);
        RESPONSE.put("msg","添加成功");

        return RESPONSE;
    }
}
