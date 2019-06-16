package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.pojo.GymSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:59
 */

public interface GymSiteRepository extends JpaRepository<GymSite, Integer> {

    /**
     * 根据gymId和siteLevel获取座席信息
     * @param gymId
     * @param siteLevel
     * @return
     * @throws Exception
     */
    GymSite getAllByGymIdAndSiteLevel(Integer gymId, Integer siteLevel) throws Exception;

    /**
     * 根据gymId获取座席信息
     * @param gymId
     * @return
     * @throws Exception
     */
    List<GymSite> getAllByGymId(Integer gymId) throws Exception;
}
