package com.zimug.bootlaunch.service;

import com.github.dozermapper.core.Mapper;
import com.zimug.bootlaunch.generator.testdb.Article;
import com.zimug.bootlaunch.generator.testdb.ArticleMapper;
import com.zimug.bootlaunch.generator.testdb2.Message;
import com.zimug.bootlaunch.generator.testdb2.MessageMapper;
import com.zimug.bootlaunch.pojo.ArticleVO;
import com.zimug.bootlaunch.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author You
 * @version 0.1.0
 * @Description
 * @create 2020-05-04 14:48
 * @since 0.1.0
 **/
@Service
public class ArticleMyBatisRestServiceImpl implements ArticleMyBatisRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MessageMapper messageMapper;


    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);
        Message message = new Message();
        message.setName("curry");
        message.setContent("萌神");
        messageMapper.insert(message);
        return null;
    }

    /**
     * 删除
     */
    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}
