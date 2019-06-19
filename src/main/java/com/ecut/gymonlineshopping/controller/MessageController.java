package com.ecut.gymonlineshopping.controller;

import com.ecut.gymonlineshopping.dto.MessageDTO;
import com.ecut.gymonlineshopping.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/17 20:42
 */

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messageForm")
    public ModelAndView addMessageForm(Model model, HttpServletRequest request) throws Exception {
        String author = (String) request.getSession().getAttribute("username");
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setAuthor(author);
        model.addAttribute("message", messageDTO);
        model.addAttribute("pageTitle", "增加留言");
        return new ModelAndView("message/addMessage", "messageForm", model);
    }

    @PostMapping("/addMessage")
    public ModelAndView addMessage(Model model, MessageDTO messageDTO, HttpServletRequest request) throws Exception {
        String author = (String) request.getSession().getAttribute("username");
        model.addAttribute("username", author);
        model.addAttribute("message", messageDTO);

        messageService.addMessage(messageDTO);

        return new ModelAndView("redirect:/message/listMessage", "messageResult", model);
    }

    @GetMapping("/listMessage")
    public ModelAndView listMessage(Model model, HttpServletRequest request) throws Exception {
//        MessageDTO messageDTO = messageService.;

        List<MessageDTO> messageDtoList = messageService.findAll();
        model.addAttribute("pageTitle", "留言板");
//        model.addAttribute("message", );
        model.addAttribute("messages", messageDtoList);
        return new ModelAndView("message/listMessage", "messageList", model);
    }


}
