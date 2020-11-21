package com.miao.test.service;

import com.github.pagehelper.PageInfo;
import com.miao.test.pojo.Users;

import java.util.List;

public interface UsersService {

    List<Users> getUserList();

    PageInfo<Users> getUsersByPage(int page, int pageSize);

}
