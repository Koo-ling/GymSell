package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.domain.Message;
import com.ecut.gymonlineshopping.domain.MessageBoard;
import com.ecut.gymonlineshopping.repository.MessageBoardRepository;
import com.ecut.gymonlineshopping.repository.MessageRepository;
import com.ecut.gymonlineshopping.service.MessageService;
import com.ecut.gymonlineshopping.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Integer messageId = KeyUtil.getRandom();
        if (null != messageDTO.getText()) {
            for (Message msg : messageDTO.getText()) {
                // 1. Message入库
                message.setId(msg.getId());
                message.setMessageId(messageId);
                message.setText(msg.getText());
                messageRepository.save(message);
            }
        }

        // 2. MessageBoard入库
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setMessageId(messageId);
        messageBoard.setTitle(messageDTO.getTitle());
        messageBoard.setAuthor(messageDTO.getAuthor());
        messageBoard.setContext(messageDTO.getContext());
        messageBoardRepository.save(messageBoard);
        return messageDTO;
    }

    @Override
    public List<MessageDTO> findAllByAuthor(String author) throws Exception {
        List<MessageBoard> messageBoardList = messageBoardRepository.findByAuthor(author);
        MessageDTO messageDTO = new MessageDTO();
        List<MessageDTO> messageDtoList = new ArrayList<>();
        for (MessageBoard messageBoard : messageBoardList) {
            List<Message> messageList =
                    messageRepository.findByMessageId(messageBoard.getMessageId());
            messageDTO.setId(messageBoard.getId());
            messageDTO.setMessageId(messageBoard.getMessageId());
            messageDTO.setAuthor(messageBoard.getAuthor());
            messageDTO.setTitle(messageBoard.getTitle());
            messageDTO.setText(messageList);
            messageDTO.setCreateTime(messageBoard.getCreateTime());
            messageDtoList.add(messageDTO);
        }

        return messageDtoList;
    }

    @Override
    public List<MessageDTO> findAll() throws Exception {
        List<MessageDTO> messageDtoList = new ArrayList<>();
        List<MessageBoard> messageBoardList = messageBoardRepository.findAll();
        for (MessageBoard messageBoard : messageBoardList) {
            MessageDTO messageDTO = new MessageDTO();
            BeanUtils.copyProperties(messageBoard, messageDTO);
            messageDtoList.add(messageDTO);
        }
        for (MessageDTO messageDTO : messageDtoList) {
            messageDTO.setText(messageRepository.findByMessageId(messageDTO.getMessageId()));
        }
        return messageDtoList;
    }
}
