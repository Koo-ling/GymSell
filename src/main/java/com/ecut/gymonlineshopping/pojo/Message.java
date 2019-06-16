package com.ecut.gymonlineshopping.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:49
 */

@Entity
@Table(name = "message")
@Data
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "text")
    private String text;

    @Column(name = "create_time")
    private Date createTime;
}
