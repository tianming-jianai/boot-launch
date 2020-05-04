package com.zimug.bootlaunch.controller;


import com.zimug.bootlaunch.pojo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public ArticleVO hello(String name) {
        ArticleVO article = new ArticleVO(1L, "zsg", "标题", "内容", LocalDateTime.now(), null);

        log.info(article.toString());

        return article;
    }
}
