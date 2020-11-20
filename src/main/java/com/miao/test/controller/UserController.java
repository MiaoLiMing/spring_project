package com.miao.test.controller;

import com.miao.common.response.Result;
import com.miao.test.jpa.UserJPA;
import com.miao.test.pojo.Users;
import com.miao.test.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户管理", value = "用户管理")
@RestController //@ResponseBody ＋ @Controller
@RequestMapping
@CrossOrigin
public class UserController {

    @Resource //类似@Autowired
    private UsersService usersService;

    @Resource
    private UserJPA userJPA;

    @ApiOperation("测试接口")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello() {
        return "Hello!This is my first Springboot Test!";
    }

    /*查询用户列表*/
    @ApiOperation("查询全部用户(操作数据库)")
    @GetMapping("/getList") //类似@RequestMapping("/getList")
    public Result getUserList() {
        List<Users> list = this.usersService.getUserList();
        return Result.ok().data("records", list);
    }

    @ApiOperation("查询全部用户(JPA)")
    @GetMapping("/list")
    public Result list() {
        return Result.ok().data("records", userJPA.findAll());//SpringDataJPA为我们提供的内置方法，它可以查询表内所有的数据
    }


    @ApiOperation("添加接口")
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Result save(Users users) {
        userJPA.save(users);
        return Result.ok();
    }

    @ApiOperation("删除接口")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result delete(Long id) {
        userJPA.deleteById(id);
        return Result.ok();
    }


}
