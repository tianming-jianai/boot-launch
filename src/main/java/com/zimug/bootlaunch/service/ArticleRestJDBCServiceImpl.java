package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.dao.ArticleJDBCDao;
import com.zimug.bootlaunch.pojo.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestJDBCService {


    @Resource
    private ArticleJDBCDao articleJDBCDao;

    @Transactional//一般在服务层做事务管理
    @Override
    public Article saveArticle(Article article) {
        articleJDBCDao.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDao.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDao.updateById(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDao.findById(id);
    }

    @Override
    public List<Article> getA11() {
        return articleJDBCDao.findAll();
    }
}
