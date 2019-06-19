package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.domain.GymInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:58
 */

public interface GymInfoRepository extends JpaRepository<GymInfo, Integer> {

    /**
     * 通过gymId获取场地信息
     * @param id
     * @return
     * @throws Exception
     */
    GymInfo getByGymId(Integer id) throws Exception;
}
