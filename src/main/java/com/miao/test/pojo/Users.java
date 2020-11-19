package com.miao.test.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@ApiModel(value="User对象", description="用户表")//swagger注解
public class Users {

    private static final long serialVersionUID = 1L;//序列化时保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "地址")
    private String address;


}
