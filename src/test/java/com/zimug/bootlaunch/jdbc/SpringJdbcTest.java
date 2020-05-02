package com.zimug.bootlaunch.jdbc;

import com.zimug.bootlaunch.dao.ArticleJDBCDao;
import com.zimug.bootlaunch.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJdbcTest {

    @Resource
    private ArticleJDBCDao articleJDBCDao;
    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;


    @Test
    public void testJdbc() {
        articleJDBCDao.save(
                Article.builder()
                        .author("zimug").title("primaryJdbcTemplate").content("ceshi").createTime(LocalDateTime.now())
                        .build(),
                primaryJdbcTemplate);
        articleJDBCDao.save(
                Article.builder()
                        .author("zimug").title("secondaryJdbcTemplate").content("ceshi").createTime(LocalDateTime.now())
                        .build(),
                secondaryJdbcTemplate);
    }


}
