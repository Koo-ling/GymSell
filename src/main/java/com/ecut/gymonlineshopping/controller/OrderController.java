package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.domain.GameTicket;
import com.ecut.gymonlineshopping.domain.Order;
import com.ecut.gymonlineshopping.dto.OrderDTO;
import com.ecut.gymonlineshopping.dto.TicketDTO;
import com.ecut.gymonlineshopping.service.GameTicketService;
import com.ecut.gymonlineshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private GameTicketService gameTicketService;

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
        return new ModelAndView("order/listOrder", "order", model);
    }

    @GetMapping("/buy/{gameId}")
    public ModelAndView buy(@PathVariable("gameId") Integer gameId,
                            Model model,
                            OrderDTO orderDTO) throws Exception {
        orderDTO.setGameId(gameId);
        model.addAttribute("order", orderDTO);
        model.addAttribute("gameId", gameId);
        model.addAttribute("ticket", gameTicketService.findByGameId(gameId));
        return new ModelAndView("order/createOrder", "createOrder", model);
    }

    @PostMapping("/buy/createOrder")
    public ModelAndView create(Model model,
                               OrderDTO orderDTO,
                               HttpServletRequest request) throws Exception {
        orderDTO.setGameId(10001);
        model.addAttribute("order", orderDTO);

        orderService.createOrder(orderDTO);

        return new ModelAndView("redirect:/order/listOrder", "orderResult", model);
    }

}
