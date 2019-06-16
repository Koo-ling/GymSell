package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.pojo.GameInfo;
import com.ecut.gymonlineshopping.pojo.GymInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:57
 */

public interface GameInfoRepository extends JpaRepository<GameInfo, Integer> {
}
