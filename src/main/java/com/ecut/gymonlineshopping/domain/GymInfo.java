package com.ecut.gymonlineshopping.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:42
 */

@Entity
@Table(name = "gym_info")
@Data
public class GymInfo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "gym_id")
    private Integer gymId;

    @Column(name = "gym_name")
    private String gynName;

    @Column(name = "location")
    private String location;
}
