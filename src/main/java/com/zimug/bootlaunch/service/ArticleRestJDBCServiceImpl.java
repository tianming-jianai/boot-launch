package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.dao.ArticleJDBCDao;
import com.zimug.bootlaunch.pojo.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestJDBCService {


    @Resource
    private ArticleJDBCDao articleJDBCDao;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Transactional//一般在服务层做事务管理
    @Override
    public Article saveArticle(Article article) {
        articleJDBCDao.save(article,primaryJdbcTemplate);
        articleJDBCDao.save(article,secondaryJdbcTemplate);
//        var i=1/0;
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDao.deleteById(id,secondaryJdbcTemplate);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDao.updateById(article,null);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDao.findById(id,null);
    }

    @Override
    public List<Article> getA11() {
        return articleJDBCDao.findAll(null);
    }
}
