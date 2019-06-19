package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.domain.MessageBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 17:14
 */

public interface MessageBoardRepository extends JpaRepository<MessageBoard, Integer> {

    /**
     * 根据 messageId 获取信息
     * @param messageId
     * @return
     * @throws Exception
     */
    MessageBoard findByMessageId(Integer messageId) throws Exception;

    /**
     * 根据作者查询
     * @param author
     * @return
     * @throws Exception
     */
    List<MessageBoard> findByAuthor(String author) throws Exception;
}
