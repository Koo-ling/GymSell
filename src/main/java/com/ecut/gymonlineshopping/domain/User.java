package com.ecut.gymonlineshopping.domain;

import com.ecut.gymonlineshopping.enums.RoleEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: Selune
 * @Date: 2019/6/12 15:13
 */

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String password;

    private Integer role = RoleEnum.NORMAL.getCode();

    private String sex;

    private String address;

    private String phone;

    private String email;
}
