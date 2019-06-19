package com.ecut.gymonlineshopping.repository;

import com.ecut.gymonlineshopping.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

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
