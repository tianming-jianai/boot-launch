package com.zimug.bootlaunch.dao;

import com.zimug.bootlaunch.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FairyLand
 */
@Slf4j
@Repository
public class ArticleJDBCDao {

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    /**
     * 保存文章
     *
     * @param article 文章
     */
    public void save(Article article, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate==null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        //jdbcTemplate适合insert update delete
        jdbcTemplate.update("insert into article(author, title, content, createTime) values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());

    }

    public void deleteById(Long id, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate==null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        int update = jdbcTemplate.update("delete from article where id=?", new Object[]{id});
        log.info("删除文章：" + update);
    }

    /**
     * 更新文章
     *
     * @param article 文章
     */
    public void updateById(Article article, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate==null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        jdbcTemplate.update("update article set author=?,title=?,content=?,createTime=? where id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId()
        );
    }

    /**
     * 根据查找文章
     *
     * @param id
     * @return
     */
    public Article findById(Long id, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate==null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        return (Article) jdbcTemplate.queryForObject("select * from article where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Article.class));

    }

    public List<Article> findAll(JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate==null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        //query用于查找结果列表
        return (List<Article>) jdbcTemplate.query("select * from article",
                new BeanPropertyRowMapper<>(Article.class));
    }


}
