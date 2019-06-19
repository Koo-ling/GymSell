package com.ecut.gymonlineshopping.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author: Selune
 * @Date: 2019/6/13 11:25
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Integer id;

    private String password;

    private String address;

    private String phone;

    private String email;
}
