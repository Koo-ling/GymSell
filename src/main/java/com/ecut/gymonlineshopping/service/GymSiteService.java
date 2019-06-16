package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.pojo.GymSite;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/12 22:10
 */

public interface GymSiteService {

    /**
     * 添加席位
     * @param gymSite
     * @return
     * @throws Exception
     */
    void addSite(GymSite gymSite) throws Exception;

    /**
     * 根据id获取席位信息
     * @param id
     * @return
     * @throws Exception
     */
    GymSite getById(Integer id) throws Exception;

    /**
     * 通过场地id和席位等级获取席位信息
     * @param gymId
     * @param siteLevel
     * @return
     * @throws Exception
     */
    GymSite getAllByGymIdAndSiteLevel(Integer gymId, Integer siteLevel) throws Exception;

    /**
     * 通过gymId获取座席信息
     * @param gymId
     * @return
     * @throws Exception
     */
    List<GymSite> getAllByGymId(Integer gymId) throws Exception;
}
