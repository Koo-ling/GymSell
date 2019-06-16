package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.CartDTO;
import com.ecut.gymonlineshopping.dto.TicketDTO;
import com.ecut.gymonlineshopping.enums.ExceptionEnum;
import com.ecut.gymonlineshopping.enums.GameStatusEnum;
import com.ecut.gymonlineshopping.exception.GymException;
import com.ecut.gymonlineshopping.pojo.GameTicket;
import com.ecut.gymonlineshopping.repository.GameTicketRepository;
import com.ecut.gymonlineshopping.service.GameTicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.internal.Ticket;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/13 16:57
 */

@Service
public class GameTicketServiceImpl implements GameTicketService {

    @Autowired
    private GameTicketRepository gameTicketRepository;

    @Override
    public void addTicket(GameTicket gameTicket) throws Exception {
        gameTicketRepository.save(gameTicket);
    }

    @Override
    public void updateTicket(TicketDTO ticketDTO) throws Exception {
        GameTicket gameTicket = gameTicketRepository.getOne(ticketDTO.getId());
        if (null == ticketDTO.getGameId()) {
            ticketDTO.setGameId(gameTicket.getGameId());
        }
        if (null == ticketDTO.getTicketMoney()) {
            ticketDTO.setTicketMoney(gameTicket.getTicketMoney());
        }
        if (null == ticketDTO.getTicketQuantity()) {
            ticketDTO.setTicketQuantity(gameTicket.getTicketQuantity());
        }
        if (null == ticketDTO.getCreateTime()) {
            ticketDTO.setCreateTime(gameTicket.getCreateTime());
        }
        if (null == ticketDTO.getCloseTime()) {
            ticketDTO.setCloseTime(gameTicket.getCloseTime());
        }
        BeanUtils.copyProperties(ticketDTO, gameTicket);
        gameTicketRepository.save(gameTicket);
    }

    @Override
    public List<GameTicket> findAllNotStart() {
        return gameTicketRepository.findByGameStatus(GameStatusEnum.NOT_START.getCode());
    }

    @Override
    public List<GameTicket> findAll() {
        return gameTicketRepository.findAll();
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cardDTO : cartDTOList) {
            GameTicket gameTicket = gameTicketRepository.findByGameId(cardDTO.getGameId());
            if (null == gameTicket) {
                throw new GymException(ExceptionEnum.GAME_NOT_EXIST);
            }
            Integer result = gameTicket.getTicketQuantity() + cardDTO.getTicketQuantity();
            gameTicket.setTicketQuantity(result);

            gameTicketRepository.save(gameTicket);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cardDTO : cartDTOList) {
            GameTicket gameTicket = gameTicketRepository.findByGameId(cardDTO.getGameId());
            if (null == gameTicket) {
                throw new GymException(ExceptionEnum.GAME_NOT_EXIST);
            }
            Integer result = gameTicket.getTicketQuantity() - cardDTO.getTicketQuantity();
            if (result < 0) {
                throw new GymException(ExceptionEnum.STOCK_ERROR);
            }

            gameTicket.setTicketQuantity(result);
            gameTicketRepository.save(gameTicket);
        }
    }

}
