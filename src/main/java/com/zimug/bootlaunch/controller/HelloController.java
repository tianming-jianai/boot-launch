package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Article hello(String name) {
        Article article = new Article(1L, "zsg", "标题", "内容", LocalDateTime.now(), null);

        log.info(article.toString());

        return article;
    }
}
