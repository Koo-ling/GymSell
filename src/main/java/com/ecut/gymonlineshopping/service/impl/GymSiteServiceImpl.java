package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.pojo.GymSite;
import com.ecut.gymonlineshopping.repository.GymSiteRepository;
import com.ecut.gymonlineshopping.service.GymSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 22:05
 */

@Service
public class GymSiteServiceImpl implements GymSiteService {

    @Autowired
    private GymSiteRepository repository;

    @Override
    public void addSite(GymSite gymSite) throws Exception {
        repository.save(gymSite);
    }

    @Override
    public GymSite getById(Integer id) throws Exception {
        return repository.getOne(id);
    }

    @Override
    public GymSite getAllByGymIdAndSiteLevel(Integer gymId, Integer siteLevel) throws Exception {
        return repository.getAllByGymIdAndSiteLevel(gymId, siteLevel);
    }

    @Override
    public List<GymSite> getAllByGymId(Integer gymId) throws Exception {
        return repository.getAllByGymId(gymId);
    }
}
