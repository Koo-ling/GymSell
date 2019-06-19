package com.ecut.gymonlineshopping.domain;

import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:38
 */

@Entity
@Table(name = "message_board")
@Data
public class MessageBoard {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "context")
    private String context;

    @Column(name = "create_time")
    private Date createTime;
}
