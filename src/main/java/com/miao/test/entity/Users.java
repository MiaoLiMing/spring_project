package com.miao.test.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@ApiModel(value="User对象", description="用户表")//swagger注解
public class Users implements Serializable{

    private static final long serialVersionUID = 1L;//序列化时保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "用户名")
    private String name;

    @Column(name = "age")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Column(name = "address")
    @ApiModelProperty(value = "地址")
    private String address;


}
