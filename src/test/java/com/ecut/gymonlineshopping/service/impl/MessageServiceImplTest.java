package com.ecut.gymonlineshopping.service.impl;

import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.pojo.Message;
import com.ecut.gymonlineshopping.pojo.MessageBoard;
import com.ecut.gymonlineshopping.repository.MessageBoardRepository;
import com.ecut.gymonlineshopping.repository.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Selune
 * @Date: 2019/6/16 17:28
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {

    @Autowired
    private MessageServiceImpl service;

    @Autowired
    private MessageBoardRepository messageBoardRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void addMessage() throws Exception {
        MessageDTO messageDTO = new MessageDTO();

        Message message1 = new Message();
//        message1.setId(1);
//        message1.setMessageId(1);
        message1.setText("你好");
        message1.setCreateTime(new Date(System.currentTimeMillis()));

        Message message2 = new Message();
//        message2.setId(2);
//        message2.setMessageId(2);
        message2.setText("你好啊");
        message2.setCreateTime(new Date(System.currentTimeMillis() + 20000));

        List<Message> messageList = new ArrayList<>();
        messageList.add(message1);
        messageList.add(message2);

        messageDTO.setMessageId(47);
        messageDTO.setTitle("你好标题");
        messageDTO.setAuthor("作者");
        messageDTO.setText(messageList);
        messageDTO.setCreateTime(new Date(System.currentTimeMillis()));

        System.out.println(messageDTO);
        service.addMessage(messageDTO);
    }

    @Test
    @Transactional
    public void addOneMessage() throws Exception {
        MessageDTO messageDTO = new MessageDTO();
        MessageBoard messageBoard = messageBoardRepository.getOne(56);
        System.out.println(messageBoard);
        messageDTO.setId(messageBoard.getId());
        messageDTO.setTitle(messageBoard.getTitle());
        messageDTO.setAuthor(messageBoard.getAuthor());
        messageDTO.setMessageId(messageBoard.getMessageId());
        messageDTO.setCreateTime(messageBoard.getCreateTime());
        System.out.println(messageDTO);
        Message message = new Message();
        message.setMessageId(messageBoard.getMessageId());
        message.setText("新留言");
        List<Message> messageList = new ArrayList<> ();
        messageList.add(message);
        System.out.println(messageList);
        messageDTO.setText(messageList);
        service.addMessage(messageDTO);
        System.out.println(messageRepository.findByMessageId(47).get(2));
        Assert.assertEquals("新留言", messageRepository.findByMessageId(47).get(2).getText());
    }

    @Test
    public void findAll() throws Exception {

    }
}