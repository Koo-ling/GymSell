package com.ecut.gymonlineshopping.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: Selune
 * @Date: 2019/6/12 21:45
 */

@Entity
@Table(name = "gym_site")
@Data
public class GymSite {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "gym_id")
    private Integer gymId;

    @Column(name = "gym_name")
    private String gymName;

    @Column(name = "site_level")
    private Integer siteLevel;

    @Column(name = "site_quantity")
    private Integer siteQuantity;
}
