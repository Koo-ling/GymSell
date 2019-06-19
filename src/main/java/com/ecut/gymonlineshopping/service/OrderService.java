package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.domain.Order;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:54
 */

public interface OrderService {

    /**
     * 根据用户名查询订单
     * @return
     * @throws Exception
     */
    List<Order> findByName(String name) throws Exception;

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    List<Order> findAll() throws Exception;

    /**
     * 根据orderId查询订单
     * @return
     * @throws Exception
     */
    List<Order> findByOrderId(String orderId) throws Exception;
}
