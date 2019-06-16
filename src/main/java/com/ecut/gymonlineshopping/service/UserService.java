package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.dto.UserDTO;
import com.ecut.gymonlineshopping.pojo.User;

/**
 * @Author: Selune
 * @Date: 2019/6/12 15:20
 */

public interface UserService {


    /**
     * 注册
     * @param user 用户
     * @throws Exception
     */
    void registerUser(User user) throws Exception;

    /**
     * 通过name和password查询用户，检测用户是否存在
     * @param name 用户名
     * @param password 用户密码
     * @throws Exception
     * @return 用户
     */
    User findByNameAndPassword(String name, String password) throws Exception;

    /**
     * 登陆验证
     * @param name 用户名
     * @param password 用户密码
     * @return 用户是否存在
     * @throws Exception
     */
    boolean loginUser(String name, String password) throws Exception;

    /**
     * 修改用户信息
     * @param userDTO
     * @throws Exception
     */
    void updateUser(UserDTO userDTO) throws Exception;

    /**
     * 查询用户是否存在
     * @param name 用户名
     * @return true 用户存在 false用户不存在
     * @throws Exception
     */
    boolean findByName(String name) throws Exception;

}
