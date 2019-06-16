package com.ecut.gymonlineshopping.dto;

import com.ecut.gymonlineshopping.pojo.Message;
import com.ecut.gymonlineshopping.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:42
 */

@Data
public class MessageDTO {

    private Integer id;

    private Integer messageId;

    private String title;

    private String author;

    private List<Message> text;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
}
