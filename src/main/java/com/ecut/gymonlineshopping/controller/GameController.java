package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.domain.GameInfo;
import com.ecut.gymonlineshopping.domain.Message;
import com.ecut.gymonlineshopping.dto.GameDTO;
import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.service.GameInfoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Integer id,
                               Model model) throws Exception {
        GameInfo gameInfo = gameInfoService.getById(id);
        model.addAttribute("game", gameInfo);
        model.addAttribute("id", id);
        return new ModelAndView("games/modifyGame", "modify", model);
    }

    @PostMapping("/modifyGame")
    public ModelAndView modify(GameDTO gameDTO) throws Exception {
        gameInfoService.modifyGame(gameDTO);
        return new ModelAndView("redirect:");
    }

    @GetMapping("/addGame")
    public ModelAndView addGame(Model model) {
        GameInfo gameInfo = new GameInfo();
        model.addAttribute("game", gameInfo);
        return new ModelAndView("games/addGame", "gameInfo", model);
    }

    @PostMapping("/addGamePost")
    public ModelAndView addGamePost(Model model,
                                    GameInfo gameInfo) throws Exception {
        model.addAttribute("gameInfo", gameInfo);
        gameInfoService.saveGame(gameInfo);
        return new ModelAndView("redirect:/games/", "addGame", model);
    }
}
