package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.pojo.ArticleVO;

import java.util.List;

/**
 * @Author: 张世罡
 * @Description:
 * @Date:
 */
public interface ArticleMyBatisRestService {

    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
