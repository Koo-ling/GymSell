package com.ecut.gymonlineshopping.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:09
 */

@Data
public class GameTicketDTO {

    private Integer id;

    private Integer gameId;

    private String gameName;

    private String location;

    private String type;

    private BigDecimal ticketMoney;

    private Integer ticketQuantity;

    private Integer gameStatus;

    private String createTime;

    private String closeTime;
}
