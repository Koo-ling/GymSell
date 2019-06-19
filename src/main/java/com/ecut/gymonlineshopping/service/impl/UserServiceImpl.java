package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.UserDTO;
import com.ecut.gymonlineshopping.domain.User;
import com.ecut.gymonlineshopping.repository.UserRepository;
import com.ecut.gymonlineshopping.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Selune
 * @Date: 2019/6/12 15:33
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) throws Exception {
        userRepository.save(user);
    }

    @Override
    public User findByNameAndPassword(String name, String password) throws Exception {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public boolean loginUser(String name, String password) throws Exception {
        User user = findByNameAndPassword(name, password);
        return null != user;
    }

    @Override
    public void updateUser(UserDTO userDTO) throws Exception {
        User user = userRepository.getOne(userDTO.getId());
        if (null == userDTO.getPassword()) {
            userDTO.setPassword(user.getPassword());
        }
        if (null == userDTO.getAddress()) {
            userDTO.setAddress(user.getAddress());
        }
        if (null == userDTO.getEmail()) {
            userDTO.setEmail(user.getEmail());
        }
        if (null == userDTO.getPhone()) {
            userDTO.setPhone(user.getPhone());
        }
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public boolean findByName(String name) throws Exception {
        User user = userRepository.findByName(name);
        if (null == user) {
            return false;
        }
        return true;
    }


}
