package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.pojo.Message;
import com.ecut.gymonlineshopping.pojo.MessageBoard;
import com.ecut.gymonlineshopping.repository.MessageBoardRepository;
import com.ecut.gymonlineshopping.repository.MessageRepository;
import com.ecut.gymonlineshopping.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: Selune
 * @Date: 2019/6/16 17:12
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageBoardRepository messageBoardRepository;

    @Override
    public MessageDTO addMessage(MessageDTO messageDTO) throws Exception {
        Message message = new Message();
        for (Message msg : messageDTO.getText()) {
            // 1. Message入库
            message.setId(msg.getId());
            message.setMessageId(messageDTO.getMessageId());
            message.setText(msg.getText());
            messageRepository.save(message);
        }

        // 2. MessageBoard入库
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setMessageId(messageDTO.getMessageId());
        messageBoard.setTitle(messageDTO.getTitle());
        messageBoard.setAuthor(messageDTO.getAuthor());
        messageBoardRepository.save(messageBoard);
        return messageDTO;
    }

    @Override
    public Page<MessageDTO> findAll(String title, Pageable pageable) throws Exception {
        return null;
    }
}
