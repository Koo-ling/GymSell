package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.domain.Order;
import com.ecut.gymonlineshopping.repository.OrderRepository;
import com.ecut.gymonlineshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:59
 */

@Service
public class OrderServiceImpl implements OrderService {

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
}
