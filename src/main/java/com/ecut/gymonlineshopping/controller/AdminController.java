package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.pojo.User;
import com.ecut.gymonlineshopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/13 15:29
 */

@RestController
@RequestMapping("/index/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public void listAllGame() {

    }

    @GetMapping("/userlist")
    public List<User> listAllUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
