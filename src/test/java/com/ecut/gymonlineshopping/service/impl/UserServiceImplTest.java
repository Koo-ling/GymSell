package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.UserDTO;
import com.ecut.gymonlineshopping.domain.User;
import com.ecut.gymonlineshopping.repository.UserRepository;
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
 * @Date: 2019/6/12 15:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserRepository repository;

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setName("xiaozhou");
        user.setPassword("123456");
        user.setEmail("12345362@qq.com");
        user.setPhone("13423241234");
        user.setSex("男");
        user.setAddress("艾兴瓦尔德大桥");
        service.registerUser(user);
        List<User> result = repository.findAll();
        Assert.assertEquals(4, result.size());
    }

    @Test
    public void findByNameAndPassword() throws Exception {
        String name = "admin";
        String password = "admin";
        User user = repository.findByNameAndPassword(name, password);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void loginUser() throws Exception {
        String name = "admin";
        String password = "admin";
        boolean result = service.loginUser(name, password);
        assertTrue(result);
    }

    @Test
    @Transactional
    public void updateUser() throws Exception {
        System.out.println(repository.getOne(7));
        UserDTO userDTO = new UserDTO();
        userDTO.setId(7);
        userDTO.setEmail("123242152@gmail.com");
        userDTO.setPhone("13423242513");
        userDTO.setPassword("123123");
        service.updateUser(userDTO);
        System.out.println(repository.getOne(7));
    }



}