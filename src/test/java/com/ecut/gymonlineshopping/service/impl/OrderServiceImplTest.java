package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.domain.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Selune
 * @Date: 2019/6/18 22:19
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void findByName() throws Exception {
        List<Order> orderList = orderService.findByName("xiaoming");
        Assert.assertEquals("13536534332", orderList.get(0).getPhone());
    }

    @Test
    public void findAll() throws Exception {
        List<Order> orderList = orderService.findAll();
        System.out.println(orderList);
        Assert.assertNotNull(orderList);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<Order> orderList = orderService.findByOrderId("102321312312");
        Assert.assertNotNull(orderList);
    }
}