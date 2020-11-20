package com.miao.test.service.impl;

import com.miao.test.service.UsersService;
import com.miao.test.mapper.UsersMapper;
import com.miao.test.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public List<Users> getUserList() {
        return this.usersMapper.getAllList();
    }
}
