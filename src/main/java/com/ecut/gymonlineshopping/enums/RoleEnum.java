package com.ecut.gymonlineshopping.enums;

import lombok.Getter;

/**
 * 用户权限
 * @Author: Selune
 * @Date: 2019/6/12 17:15
 */

@Getter
public enum RoleEnum {

    /**
     * 0 普通用户
     * 1 管理员
     */
    NORMAL(0, "普通用户"),
    ADMINISTRATOR(1, "管理员")
    ;

    private Integer code;

    private String msg;

    RoleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
