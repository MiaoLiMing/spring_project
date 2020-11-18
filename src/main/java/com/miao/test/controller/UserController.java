package com.miao.test.controller;

import com.miao.common.response.Result;
import com.miao.test.pojo.Users;
import com.miao.test.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "用户管理")
@RestController //@ResponseBody ＋ @Controller
@RequestMapping
@CrossOrigin
public class UserController {

    @Resource //类似@Autowired
    private UsersService usersService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello() {
        return "Hello!This is my first Springboot Test!";
    }

    /*查询用户列表*/
    @ApiOperation("查询用户列表")
    @GetMapping("/getList") //类似@RequestMapping("/getList")
    public Result getUserList() {
        List<Users> list = this.usersService.getUserList();
        System.out.println(Result.ok().data("list", list));
        return Result.ok().data("list", list);
    }


}
