package com.miao.test.service.impl;

import com.miao.test.mapper.UsersMapper;
import com.miao.test.pojo.Users;
import com.miao.test.service.UsersService;
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
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return this.usersMapper.selectUserAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return this.usersMapper.selectUserById(id);
    }

    @Override
    public void updateUser(Users users) {
        this.usersMapper.updateUser(users);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.usersMapper.deleteUserById(id);
    }

    @Override
    public List<Users> getUserList() {
        return this.usersMapper.getAllList();
    }
}
