package com.ecut.gymonlineshopping.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


/**
 * @Author: Selune
 * @Date: 2019/6/16 16:24
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameDTO {

    private Integer id;

    private String gameResult;

}
