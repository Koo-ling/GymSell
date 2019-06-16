package com.ecut.gymonlineshopping.enums;

import lombok.Getter;

/**
 * @Author: Selune
 * @Date: 2019/6/13 13:35
 */

@Getter
public enum ExceptionEnum {

    /**
     * 101 用户已存在
     * 102 参数错误
     * 103 用户不存在
     * 104 比赛不存在
     * 105 库存错误
     */
    MEMBER_EXIST(101, "用户已存在"),
    PARAM_ERROR(102, "参数错误"),
    MEMBER_NOT_EXIST(103, "用户不存在"),
    GAME_NOT_EXIST(104, "比赛不存在"),
    STOCK_ERROR(105, "库存错误")
    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
