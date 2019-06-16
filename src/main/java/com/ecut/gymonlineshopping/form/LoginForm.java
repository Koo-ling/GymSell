package com.ecut.gymonlineshopping.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: Selune
 * @Date: 2019/6/13 13:50
 */

@Data
public class LoginForm {

    /** 用户名 */
    @NotEmpty(message = "用户名必填")
    private String name;

    /** 用户密码 */
    @NotEmpty(message = "用户密码必填")
    private String password;
}
