package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.GameDTO;
import com.ecut.gymonlineshopping.pojo.GameInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:10
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameInfoServiceImplTest {

    @Autowired
    private GameInfoServiceImpl service;

    @Test
    public void saveGame() throws Exception {
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGameId(10001);
        gameInfo.setGameName("雄鹿vs猛龙");
        gameInfo.setGameType("篮球");
        gameInfo.setGameOrganizer("北京");
        gameInfo.setGameMember("雄鹿队，猛龙队");
        gameInfo.setGameTime("2019-06-02 08:00");
        gameInfo.setGameLocation("场馆100001");
        gameInfo.setGameResult("112vs118");
        service.saveGame(gameInfo);
    }

    @Test
    public void findAll() throws Exception {
        List<GameInfo> getAll = service.findAll();
        System.out.println(getAll);
        Assert.assertNotNull(getAll);
    }

    @Test
    @Transactional
    public void modifyGame() throws Exception {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(28);
        gameDTO.setGameResult("112vs118");
        service.modifyGame(gameDTO);
        System.out.println(service.getById(28));
        Assert.assertEquals("112vs118", service.getById(28).getGameResult());
    }
}