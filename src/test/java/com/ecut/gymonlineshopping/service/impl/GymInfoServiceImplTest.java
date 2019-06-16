package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.pojo.GymInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Selune
 * @Date: 2019/6/16 21:45
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GymInfoServiceImplTest {

    @Autowired
    private GymInfoServiceImpl service;

    @Test
    public void addGymInfo() throws Exception {
        GymInfo gymInfo = new GymInfo();
        gymInfo.setGymId(40001);
        gymInfo.setGynName("1号网球场");
        gymInfo.setLocation("东区网球场A区");
        service.addGymInfo(gymInfo);
        Assert.assertNotNull(service.getByGymId(40001));
    }

    @Test
    public void getAll() throws Exception {
        List<GymInfo> gymInfoList = service.getAll();
        Integer size = gymInfoList.size();
        System.out.println(size);
        Assert.assertEquals(new Integer(7), size);
    }

    @Test
    public void getById() throws Exception {
        GymInfo gymInfo = service.getById(2);
        Assert.assertNotNull(gymInfo);
    }
}