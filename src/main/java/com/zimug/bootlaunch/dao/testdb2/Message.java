package com.zimug.bootlaunch.dao.testdb2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author You
 * @version 0.1.0
 * @Description
 * @create 2020-05-03 21:21
 * @since 0.1.0
 **/
@Data
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

}
