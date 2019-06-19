package com.ecut.gymonlineshopping.service;

import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
     * 根据作者查询
     * @param author
     * @return
     * @throws Exception
     */
    List<MessageDTO> findAllByAuthor(String author) throws Exception;

    /**
     * 查询所有留言
     * @return
     * @throws Exception
     */
    List<MessageDTO> findAll() throws Exception;
}
