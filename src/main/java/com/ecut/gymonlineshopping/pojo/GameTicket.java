package com.ecut.gymonlineshopping.pojo;

import com.ecut.gymonlineshopping.enums.GameStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:38
 */

@Entity
@Table(name = "game_ticket")
@Data
public class GameTicket {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "ticket_money")
    private BigDecimal ticketMoney;

    @Column(name = "ticket_quantity")
    private Integer ticketQuantity;

    @Column(name = "game_status")
    private Integer gameStatus = GameStatusEnum.NOT_START.getCode();

    @Column(name = "ticket_createtime")
    private String createTime;

    @Column(name = "ticket_closetime")
    private String closeTime;
}
