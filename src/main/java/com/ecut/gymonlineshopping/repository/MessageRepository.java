package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.pojo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:52
 */

public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * 根据messageId查询留言
     * @param messageId
     * @return
     * @throws Exception
     */
    List<Message> findByMessageId(Integer messageId) throws Exception;
}
