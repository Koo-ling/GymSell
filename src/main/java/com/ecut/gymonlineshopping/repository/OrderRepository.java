package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:53
 */

public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * 根据用户名查询订单
     * @param name
     * @return
     * @throws Exception
     */
    List<Order> findByName(String name) throws Exception;

    /**
     * 根据orderId查询订单
     * @param orderId
     * @return
     * @throws Exception
     */
    List<Order> findByOrderId(String orderId) throws Exception;
}
