package com.miao.test.controller;

import com.miao.common.response.Result;
import com.miao.test.pojo.Users;
import com.miao.test.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    /* 页面跳转*/
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /*添加用户*/
    @RequestMapping("/addUser")
    public String addUser(Users users) {
        this.usersService.addUser(users);
        return "ok";
    }

    /*查询用户*/
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model) {
        List<Users> list = this.usersService.findUserAll();
        model.addAttribute("list", list);
        return "showUsers";
    }

    /*根据id查询用户*/
    @RequestMapping("/findUserById")
    public String findUserById(Integer id, Model model) {
        Users users = this.usersService.findUserById(id);
        model.addAttribute("users", users);
        return "updateUser";
    }

    /*更新用户*/
    @RequestMapping("/editUser")
    public String editUser(Users users) {
        this.usersService.updateUser(users);
        return "ok";
    }

    /*根据id删除用户*/
    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer id) {
        this.usersService.deleteUserById(id);
        return "redirect:/users/findUserAll";
    }

    /*test接口*/
    @RequestMapping("/getUserList")
    public String getUserList(Model model) {
        List<Users> list = this.usersService.getUserList();
        model.addAttribute("list", list);
        return "showUsers";
    }
}
