package com.ecut.gymonlineshopping.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Selune
 * @Date: 2019/6/19 14:57
 */

@Data
public class OrderDTO {

    private Integer orderId;

    private String name;

    private String address;

    private String phone;

    private String email;

    private Integer ticketQuantity;

    private BigDecimal amount;

    private Integer gameId;

    private String gameName;

    private String gameLocation;

    private String gameTime;

}
