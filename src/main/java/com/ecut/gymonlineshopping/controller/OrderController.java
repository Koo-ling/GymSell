package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.domain.Order;
import com.ecut.gymonlineshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/18 21:52
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView listAll(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        List<Order> orderList;
        if (name.equals("admin")) {
            orderList = orderService.findAll();
        } else {
            orderList = orderService.findByName(name);
        }
        model.addAttribute("orderList", orderList);
        return new ModelAndView("order/listOrder", "adminOrder", model);
    }


}
