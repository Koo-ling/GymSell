package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.domain.GymSite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 22:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GymSiteServiceImplTest {

    @Autowired
    private GymSiteServiceImpl service;

    @Test
    public void addSite() throws Exception {
        GymSite gymSite = new GymSite();
        gymSite.setGymId(10001);
        gymSite.setGymName("1号篮球场");
        gymSite.setSiteLevel(2);
        gymSite.setSiteQuantity(2000);
        service.addSite(gymSite);
    }

    @Test
    @Transactional
    public void getById() throws Exception {
        GymSite gymSite = service.getById(30);
        System.out.println(gymSite);
    }

    @Test
    public void getAllByGymIdAndSiteLevel() throws Exception {
        GymSite gymSite = service.getAllByGymIdAndSiteLevel(10001, 1);
        System.out.println(gymSite);
        Assert.assertEquals(new Integer(500), gymSite.getSiteQuantity());
    }

    @Test
    public void getAllByGymId() throws Exception {
        List<GymSite> gymSiteList = service.getAllByGymId(10001);
        System.out.println(gymSiteList);
        Assert.assertEquals(3, gymSiteList.size());
    }
}