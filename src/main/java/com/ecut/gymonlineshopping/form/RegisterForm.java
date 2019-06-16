package com.ecut.gymonlineshopping.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


/**
 * 用户注册信息表单
 * @Author: Selune
 * @Date: 2019/6/13 12:33
 */

@Data
public class RegisterForm {

    /** 用户姓名 */
    @NotEmpty(message = "用户名必填")
    private String name;

    /** 用户密码 */
    @NotEmpty(message = "密码必填")
    private String password;

    /** 用户性别 */
    @NotEmpty(message = "性别必填")
    private String sex;

    /** 用户地址 */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 用户电话 */
    @NotEmpty(message = "电话必填")
    private String phone;

    @NotEmpty(message = "邮箱必填")
    private String email;
}
