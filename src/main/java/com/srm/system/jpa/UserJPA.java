package com.srm.system.jpa;

import com.srm.system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<Users, Long>,//SpringDataJPA提供的简单数据操作接口
        JpaSpecificationExecutor<Users>, //SpringDataJPA提供的复杂查询接口
        //序列化接口
        Serializable {
}


