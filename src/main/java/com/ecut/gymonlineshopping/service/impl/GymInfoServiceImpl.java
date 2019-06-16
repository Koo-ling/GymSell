package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.pojo.GymInfo;
import com.ecut.gymonlineshopping.repository.GymInfoRepository;
import com.ecut.gymonlineshopping.service.GymInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 21:38
 */

@Service
public class GymInfoServiceImpl implements GymInfoService {

    @Autowired
    private GymInfoRepository repository;

    @Override
    public void addGymInfo(GymInfo gymInfo) throws Exception {
        repository.save(gymInfo);
    }

    @Override
    public List<GymInfo> getAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public GymInfo getById(Integer id) throws Exception {
        return repository.getOne(id);
    }

    @Override
    public GymInfo getByGymId(Integer id) throws Exception {
        return repository.getByGymId(id);
    }
}
