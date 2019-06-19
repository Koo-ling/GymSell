package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.domain.GameInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:57
 */

public interface GameInfoRepository extends JpaRepository<GameInfo, Integer> {

    /**
     * 根据gameId查询比赛
     * @param gameId
     * @return
     * @throws Exception
     */
    GameInfo findByGameId(Integer gameId) throws Exception;
}
