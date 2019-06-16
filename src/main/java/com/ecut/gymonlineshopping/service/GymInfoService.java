package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.pojo.GymInfo;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/12 22:10
 */

public interface GymInfoService {

    /**
     * 添加场馆信息
     * @param gymInfo
     * @throws Exception
     */
    void addGymInfo(GymInfo gymInfo) throws Exception;

    /**
     * 获取所有场馆信息
     * @return
     * @throws Exception
     */
    List<GymInfo> getAll() throws Exception;

    /**
     * 根据id获取场馆信息
     * @param id
     * @return
     * @throws Exception
     */
    GymInfo getById(Integer id) throws Exception;

    /**
     * 根据场地id获取场馆信息
     * @param id
     * @return
     * @throws Exception
     */
    GymInfo getByGymId(Integer id) throws Exception;
}
