package com.ecut.gymonlineshopping.dto;

import com.ecut.gymonlineshopping.domain.Message;
import com.ecut.gymonlineshopping.utils.KeyUtil;
import com.ecut.gymonlineshopping.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/16 16:42
 */

@Data
public class MessageDTO {

    public Integer id;

    public Integer messageId;

    public String title;

    public String author;

    public String context;

    public List<Message> text;

    @JsonSerialize(using = Date2LongSerializer.class)
    public Date createTime;
}
