package com.ecut.gymonlineshopping.dto;

import com.ecut.gymonlineshopping.enums.GameStatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Selune
 * @Date: 2019/6/13 17:01
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDTO {

    private Integer id;

    private Integer gameId;

    private BigDecimal ticketMoney;

    private Integer ticketQuantity;

    private Integer gameStatus;

    private String createTime;

    private String closeTime;
}
