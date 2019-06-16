package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.TicketDTO;
import com.ecut.gymonlineshopping.pojo.GameTicket;
import com.ecut.gymonlineshopping.repository.GameTicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Selune
 * @Date: 2019/6/13 17:38
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTicketServiceImplTest {

    @Autowired
    private GameTicketServiceImpl service;

    @Autowired
    private GameTicketRepository repository;

    @Test
    public void addTicket() throws Exception {
//        Date createTime = new Date("2019-06-1")

        GameTicket gameTicket = new GameTicket();
        gameTicket.setGameId(10001);
        gameTicket.setTicketMoney(new BigDecimal(399));
        gameTicket.setTicketQuantity(200);
        gameTicket.setCreateTime("2019-06-05 08:00");
        gameTicket.setCloseTime("2019-06-05 10:00");
        gameTicket.setGameStatus(1);
        System.out.println(gameTicket);
        service.addTicket(gameTicket);

    }

    @Test
    @Transactional
    public void updateTicket() throws Exception {
        System.out.println(repository.getOne(26));
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(26);
        ticketDTO.setTicketQuantity(100);
        service.updateTicket(ticketDTO);
        System.out.println(repository.getOne(26));
    }

    @Test
    public void findAllNotStart() throws Exception {
        List<GameTicket> gameTicketList = service.findAllNotStart();
        System.out.println(gameTicketList);
    }

    @Test
    public void findAll() throws Exception {
        List<GameTicket> gameTicketList = service.findAll();
        System.out.println(gameTicketList);
    }
}