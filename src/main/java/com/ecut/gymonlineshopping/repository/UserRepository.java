package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Selune
 * @Date: 2019/6/12 15:18
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过name 和 password 查询用户，用于登陆验证
     * @param name 用户名
     * @param password 用户密码
     * @return
     */
    User findByNameAndPassword(String name, String password);

    /**
     * 通过name 查询用户
     * @param name 用户名
     * @return
     */
    User findByName(String name);
}
