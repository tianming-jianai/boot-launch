package com.zimug.bootlaunch.jpa;

import com.zimug.bootlaunch.dao.testdb.ArticleDO;
import com.zimug.bootlaunch.dao.testdb.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author You
 * @version 0.1.0
 * @Description
 * @create 2020-05-03 20:47
 * @since 0.1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void userTest() {
        ArticleDO article = articleRepository.findByAuthor("zimuge");
        System.out.println(article);
    }

}
