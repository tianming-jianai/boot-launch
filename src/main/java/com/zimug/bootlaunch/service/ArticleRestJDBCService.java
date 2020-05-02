package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.pojo.Article;

import java.util.List;

public interface ArticleRestJDBCService {
    public Article saveArticle(Article article);

    public void deleteArticle(Long id);

    public void updateArticle(Article article);

    public Article getArticle(Long id);

    public List<Article> getA11();
}

