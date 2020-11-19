package com.miao.test.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.miao.common.response.Result;
import com.miao.test.pojo.Users;
import com.miao.test.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户管理",value = "用户管理")
@RestController //@ResponseBody ＋ @Controller
@RequestMapping
@CrossOrigin
public class UserController {

    @Resource //类似@Autowired
    private UsersService usersService;

    @ApiOperation("测试接口")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello() {
        return "Hello!This is my first Springboot Test!";
    }

    /*查询用户列表*/
    @ApiOperation("查询用户列表")
    @GetMapping("/getList") //类似@RequestMapping("/getList")
    public Result getUserList(@RequestParam(value="当前页",defaultValue="1") int page,
                              @RequestParam(value = "总数", defaultValue = "4") int limit) {
        //这个一定要放在第一行,否则无法进行分页
        Page currentPage= PageHelper.startPage(page,limit);

        List<Users> list = this.usersService.getUserList();

        //分页
//        PageInfo pageInfo = new PageInfo(list);

//        System.out.println(currentPage);
        return Result.ok().data("records",list);
    }
}
