package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameInfoService gameInfoService;

    @GetMapping("/")
    public ModelAndView listGame(Model model) throws Exception {
        model.addAttribute("games", gameInfoService.findAll());
        return new ModelAndView("games/listGame", "listGame", model);
    }
}
