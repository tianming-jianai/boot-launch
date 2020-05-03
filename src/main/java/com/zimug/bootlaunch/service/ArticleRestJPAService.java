package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.pojo.ArticleVO;

import java.util.List;

/**
 * @author FairyLand
 */
public interface ArticleRestJPAService {

    /**
     * vo
     * @param articleVO vo
     * @return vo
     */
    ArticleVO saveArticle(ArticleVO articleVO);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO articleVO);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
