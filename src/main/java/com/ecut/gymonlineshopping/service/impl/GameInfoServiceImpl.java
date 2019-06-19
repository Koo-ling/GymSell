package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.GameDTO;
import com.ecut.gymonlineshopping.domain.GameInfo;
import com.ecut.gymonlineshopping.repository.GameInfoRepository;
import com.ecut.gymonlineshopping.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/13 11:33
 */

@Service
public class GameInfoServiceImpl implements GameInfoService {

    @Autowired
    private GameInfoRepository repository;

    @Override
    public void saveGame(GameInfo gameInfo) throws Exception {
        gameInfo.setGameResult("比赛未开始");
        repository.save(gameInfo);
    }

    @Override
    public List<GameInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void modifyGame(GameDTO gameDTO) throws Exception {
        GameInfo gameInfo = repository.getOne(gameDTO.getId());
        gameInfo.setGameResult(gameDTO.getGameResult());
        repository.save(gameInfo);
    }

    @Override
    public GameInfo getById(Integer id) throws Exception {
        return repository.getOne(id);
    }
}
