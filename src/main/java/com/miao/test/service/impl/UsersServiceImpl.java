package com.miao.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miao.test.jpa.UserJPA;
import com.miao.test.service.UsersService;
import com.miao.test.mapper.UsersMapper;
import com.miao.test.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public List<Users> getUserList() {
        return this.usersMapper.getAllList();
    }

    @Override
    public PageInfo<Users> getUsersByPage(int page, int pageSize) {
        //开启分页支持
        PageHelper.startPage(page, pageSize);
        //调取dao层查询所有
        List<Users> list = usersMapper.getAllList();
        PageInfo pageInfo = new PageInfo(list);

        System.out.println("获取当前页:" + pageInfo.getPageNum());
        System.out.println("获取总页数:" + pageInfo.getPages());
        System.out.println("每页条数:" + pageInfo.getPageSize());
        System.out.println("总记录数:" + pageInfo.getTotal());
        System.out.println("获取第一页:" + pageInfo.getNavigateFirstPage());
        System.out.println("获取最后一页:" + pageInfo.getNavigateLastPage());
        System.out.println("获取当前页数据:" + pageInfo.getList().size());

        return pageInfo;
    }
}
