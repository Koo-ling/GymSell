package com.ecut.gymonlineshopping.enums;

import lombok.Getter;

/**
 * @Author: Selune
 * @Date: 2019/6/16 15:54
 */

@Getter
public enum  GameStatusEnum {

    /**
     * 0 比赛未开始
     * 1 比赛已结束
     */
    NOT_START(0, "比赛未开始"),
    FINISHED(1, "比赛已结束")
    ;

    private Integer code;

    private String msg;

    GameStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
