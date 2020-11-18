package com.miao.test.controller;

import com.miao.common.response.Result;
import com.miao.test.pojo.Users;
import com.miao.test.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@ResponseBody ＋ @Controller
@RequestMapping
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String hello(){
        return "Hello!This is my first Springboot Test!";
    }

    /*test接口*/
    @RequestMapping("/getList")
    public Result getUserList() {
        List<Users> list = this.usersService.getUserList();
        System.out.println(Result.ok().data("list", list));
        return Result.ok().data("list", list);
    }


}
