package com.zimug.bootlaunch.server;

import com.zimug.bootlaunch.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 张世罡
 * @Description:
 * @Date:
 */
@Slf4j
@Service
public class ArticleRestService {
    public String saveArticle(Article article) {

        log.info("saveArticle:{}", article);
        return "测试";
    }
}
