package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.domain.GameInfo;
import com.ecut.gymonlineshopping.domain.GameTicket;
import com.ecut.gymonlineshopping.domain.Order;
import com.ecut.gymonlineshopping.dto.OrderDTO;
import com.ecut.gymonlineshopping.repository.GameInfoRepository;
import com.ecut.gymonlineshopping.repository.OrderRepository;
import com.ecut.gymonlineshopping.service.GameInfoService;
import com.ecut.gymonlineshopping.service.GameTicketService;
import com.ecut.gymonlineshopping.service.OrderService;
import com.ecut.gymonlineshopping.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:59
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GameTicketService gameTicketService;

    @Autowired
    private GameInfoRepository gameInfoRepository;

    @Autowired
    private GameInfoService gameInfoService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findByName(String name) throws Exception {
        return orderRepository.findByName(name);
    }

    @Override
    public List<Order> findAll() throws Exception {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByOrderId(String orderId) throws Exception {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {

        Integer gameId = orderDTO.getGameId();
        // 1. 查询商品
        GameTicket gameTicket = gameTicketService.findByGameId(gameId);
        GameInfo gameInfo = gameInfoRepository.findByGameId(gameId);

        // 2. 写入数据库
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setTicketMoney(gameTicket.getTicketMoney());
        order.setOrderId(KeyUtil.getOrderId());
        order.setOrderAmount();
        orderRepository.save(order);

        // 3. 扣库存
        int stock = gameTicket.getTicketQuantity() - orderDTO.getTicketQuantity();
        gameTicket.setTicketQuantity(stock);
        gameTicketService.save(gameTicket);

        return orderDTO;
    }
}
