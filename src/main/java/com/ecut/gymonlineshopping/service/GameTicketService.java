package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.dto.CartDTO;
import com.ecut.gymonlineshopping.dto.TicketDTO;
import com.ecut.gymonlineshopping.domain.GameTicket;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/12 22:09
 */

public interface GameTicketService {

    /**
     * 新增门票
     * @param gameTicket 比赛门票信息
     * @throws Exception
     */
    void addTicket(GameTicket gameTicket) throws Exception;

    /**
     * 更新门票信息
     * @param ticketDTO 门票
     * @throws Exception
     */
    void updateTicket(TicketDTO ticketDTO) throws Exception;

    /**
     * 查询所有可售比赛
     * @return
     */
    List<GameTicket> findAllNotStart();

    /**
     * 查询所有比赛
     * @return
     */
    List<GameTicket> findAll();

    void save(GameTicket gameTicket) throws Exception;

    /**
     * 根据gameId获取比赛
     * @param gameId
     * @return
     */
    GameTicket findByGameId(Integer gameId);

    /** 减少库存 */
    void decreaseStock(List<CartDTO> cartDTOList);
}
