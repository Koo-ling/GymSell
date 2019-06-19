package com.ecut.gymonlineshopping.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Selune
 * @Date: 2019/6/18 22:59
 */

@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping("/")
    public ModelAndView listGame(Model model) throws Exception {
        return new ModelAndView("game/listGame", "listGame", model);
    }
}
