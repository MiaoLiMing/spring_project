package com.srm.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "users")
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

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    @Column(name = "start_time")
    @ApiModelProperty(value = "起始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start_time;


}
