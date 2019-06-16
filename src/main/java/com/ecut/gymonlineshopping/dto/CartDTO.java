package com.ecut.gymonlineshopping.dto;

import lombok.Data;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:54
 */

@Data
public class CartDTO {

    private Integer gameId;

    private Integer ticketQuantity;

    public CartDTO(Integer gameId, Integer ticketQuantity) {
        this.gameId = gameId;
        this.ticketQuantity = ticketQuantity;
    }
}
