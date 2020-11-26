package com.miao.test.mapper;

import com.miao.test.pojo.Users;

import java.util.List;

public interface UsersMapper {

    void insertUser(Users users);

    List<Users> selectUserAll();

    Users selectUserById(Integer id);

    void updateUser(Users users);

    void deleteUserById(Integer id);

    List<Users> getAllList();
}
