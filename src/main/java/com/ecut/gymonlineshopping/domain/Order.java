package com.ecut.gymonlineshopping.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:42
 */

@Entity
@Table(name = "ticket_order")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String orderId;

    private BigDecimal orderAmount;

    private Date createTime;

    private Integer gameId;

    private BigDecimal ticketMoney;

    private Integer ticketQuantity;

    private String gameName;

    private String gameLocation;

    private Date gameTime;

    public void setOrderAmount() {
        this.orderAmount = this.ticketMoney.multiply(new BigDecimal(this.ticketQuantity));
    }
}
