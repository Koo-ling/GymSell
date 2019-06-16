package com.ecut.gymonlineshopping.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:31
 */

@Entity
@Table(name = "game_info")
@Data
public class GameInfo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_type")
    private String gameType;

    @Column(name = "game_organizer")
    private String gameOrganizer;

    @Column(name = "game_member")
    private String gameMember;

    @Column(name = "game_time")
    private String gameTime;

    @Column(name = "game_location")
    private String gameLocation;

    @Column(name = "game_result")
    private String gameResult;
}
