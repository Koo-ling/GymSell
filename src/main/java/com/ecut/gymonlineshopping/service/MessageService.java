package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:52
 */

public interface MessageService {

    /**
     * 创建留言
     * @param messageDTO
     * @return
     * @throws Exception
     */
    MessageDTO addMessage(MessageDTO messageDTO) throws Exception;

    /**
     * 查看留言
     * @param title
     * @param pageable
     * @return
     * @throws Exception
     */
    Page<MessageDTO> findAll(String title, Pageable pageable) throws Exception;
}
