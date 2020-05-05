package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Article hello(String name) {
        Article article = new Article("aaa", "zsg", "标题", "内容", LocalDateTime.now(), null);

        log.info(article.toString());

        return article;
    }
}
