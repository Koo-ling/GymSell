package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.pojo.GameTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:58
 */

public interface GameTicketRepository extends JpaRepository<GameTicket, Integer> {

    /**
     * 根据比赛状态查询对应比赛
     * @param gameStatus
     * @return
     */
    List<GameTicket> findByGameStatus(Integer gameStatus);

    /**
     * 根据比赛id查询对应比赛
     * @param gameId
     * @return
     */
    GameTicket findByGameId(Integer gameId);
}
