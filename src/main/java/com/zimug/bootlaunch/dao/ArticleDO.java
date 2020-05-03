package com.zimug.bootlaunch.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author FairyLand
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="article")
public class ArticleDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,length = 32)
    private String author;

    @Column(nullable = false, unique = true,length = 32)
    private String title;

    @Column(length = 512)
    private String content;

    private LocalDateTime createTime;
}
