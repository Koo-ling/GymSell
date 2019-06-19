package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.domain.GameTicket;
import com.ecut.gymonlineshopping.domain.MessageBoard;
import com.ecut.gymonlineshopping.dto.GameTicketDTO;
import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.repository.GameInfoRepository;
import com.ecut.gymonlineshopping.service.GameInfoService;
import com.ecut.gymonlineshopping.service.GameTicketService;
import com.ecut.gymonlineshopping.service.impl.GameTicketServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/18 20:25
 */

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private GameTicketService gameTicketService;

    @Autowired
    private GameInfoRepository gameInfoRepository;

    @GetMapping("/")
    public ModelAndView listTicket(Model model) throws Exception {
        List<GameTicket> gameTicketList = gameTicketService.findAllNotStart();
        List<GameTicketDTO> gameTicketDtoList = new ArrayList<>();
        for (GameTicket gameTicket : gameTicketList) {
            GameTicketDTO gameTicketDTO = new GameTicketDTO();
            BeanUtils.copyProperties(gameTicket, gameTicketDTO);
            gameTicketDTO.setGameName(gameInfoRepository.findByGameId(gameTicketDTO.getGameId()).getGameName());
            gameTicketDTO.setLocation(gameInfoRepository.findByGameId(gameTicketDTO.getGameId()).getGameLocation());
            gameTicketDTO.setType(gameInfoRepository.findByGameId(gameTicketDTO.getGameId()).getGameType());
            gameTicketDtoList.add(gameTicketDTO);
        }
        model.addAttribute("tickets", gameTicketDtoList);
        model.addAttribute("buy", "购买");
        return new ModelAndView("tickets/tickets", "ticketList", model);
    }

    @GetMapping("/buy/{gameId}")
    public ModelAndView buy(@PathVariable("gameId") Integer gameId,
                            Model model) throws Exception {
        return null;
    }
}
