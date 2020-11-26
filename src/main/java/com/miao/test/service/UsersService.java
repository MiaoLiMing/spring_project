package com.miao.test.service;

import com.miao.test.pojo.Users;

import java.util.List;

public interface UsersService {

    void addUser(Users users);

    List<Users> findUserAll();

    Users findUserById(Integer id);

    void updateUser(Users users);

    void deleteUserById(Integer id);

    List<Users> getUserList();
}
