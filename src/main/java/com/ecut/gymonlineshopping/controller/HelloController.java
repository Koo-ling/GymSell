package com.ecut.gymonlineshopping.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Selune
 * @Date: 2019/6/16 15:31
 */

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/index")
    public ModelAndView index(Model model) {
        model.addAttribute("title", "体育馆比赛售票系统");
        return new ModelAndView("index", "index", model);
    }
}
