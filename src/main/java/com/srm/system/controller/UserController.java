package com.srm.system.controller;

import com.github.pagehelper.PageInfo;
import com.srm.common.response.Result;
import com.srm.system.jpa.UserJPA;
import com.srm.system.entity.Users;
import com.srm.system.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Api(value = "用户管理", tags = "用户管理")
@RestController //@ResponseBody ＋ @Controller
@RequestMapping
@CrossOrigin
public class UserController {

    @Resource //类似@Autowired
    private UsersService usersService;

    @Resource
    private UserJPA userJPA;

    /*查询用户列表*/
    @ApiOperation("查询全部")
    @GetMapping("/getList") //类似@RequestMapping("/getList")
    public Result getUserList() {
        List<Users> list = this.usersService.getUserList();
        return Result.ok().data("records", list);
    }

    /*分页查询方法*/
    @ApiOperation("分页查询全部")
    @GetMapping("/getListByPage") //类似@RequestMapping("/getList")
    public Result getUsersByPage(int page, int pageSize) {
        PageInfo<Users> pageInfo = this.usersService.getUsersByPage(page, pageSize);

        Map<String, Object> pages = new HashMap<>();
        pages.put("currentPage", pageInfo.getPageNum());
        pages.put("total", pageInfo.getTotal());

        return Result.ok().data("pageInfo", pages).data("list", pageInfo.getList());
    }

    @ApiOperation("分页查询全部(JPA)")
    @GetMapping("/list")
    public Result list(int page, int pageSize) {

        Sort sort = Sort.by(Sort.Order.asc("id"));//asc升序  desc降序
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);
        System.out.println(pageable);
        Iterator<Users> all = userJPA.findAll(pageable).iterator();//findAll-SpringDataJPA内置方法，查询表内所有数据

        System.out.println("22" + all);
        //userJPA.findAll(pageable).getContent()获取当前页数据
        //userJPA.findAll(pageable).getContent().size()获取当前页数量
        //userJPA.findAll(pageable).getTotalElements()总数
        Long total = userJPA.findAll(pageable).getTotalElements();

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("currentPage", page);
        pageInfo.put("total", total);

        List<Users> list = new ArrayList<Users>();
        while (all.hasNext()) {
            list.add(all.next());
        }
        System.out.println(list);
        return Result.ok().data("pageInfo", pageInfo).data("list", list);
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
