package com.srm.system.service;

import com.github.pagehelper.PageInfo;
import com.srm.system.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getUserList();

    PageInfo<Users> getUsersByPage(int page, int pageSize);

}
