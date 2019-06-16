package com.ecut.gymonlineshopping.enums;

import lombok.Getter;

/**
 * 座席等级
 * @Author: Selune
 * @Date: 2019/6/12 21:48
 */

@Getter
public enum SiteLevelEnum {

    /**
     * 0 贵宾席
     * 1 标准席
     * 2 低价席
     */
    VIP(0, "贵宾席"),
    STANDARD(1, "标准席"),
    LOW_CAST(2, "低价席")
    ;

    private Integer code;

    private String msg;

    SiteLevelEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
