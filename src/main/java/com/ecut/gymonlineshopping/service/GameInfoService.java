package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.dto.GameDTO;
import com.ecut.gymonlineshopping.domain.GameInfo;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/12 22:09
 */

public interface GameInfoService {

    /**
     * 添加比赛
     * @param gameInfo 比赛信息
     * @throws Exception
     */
    void saveGame(GameInfo gameInfo) throws Exception;

    /**
     * 查找所有比赛
     * @return
     */
    List<GameInfo> findAll();

    /**
     * 更新比赛结果
     * @param gameDTO
     * @throws Exception
     */
    void modifyGame(GameDTO gameDTO) throws Exception;

    /**
     * 根据id查找比赛
     * @param id
     * @return
     * @throws Exception
     */
    GameInfo getById(Integer id) throws Exception;
}
