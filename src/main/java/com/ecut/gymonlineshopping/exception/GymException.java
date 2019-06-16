package com.ecut.gymonlineshopping.exception;

import com.ecut.gymonlineshopping.enums.ExceptionEnum;

/**
 * Gym 异常管理
 * @Author: Selune
 * @Date: 2019/6/13 13:33
 */

public class GymException extends RuntimeException {

    private Integer code;

    public GymException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GymException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
}
