package com.zimug.bootlaunch.service;

import com.github.dozermapper.core.Mapper;
import com.zimug.bootlaunch.dao.testdb.ArticleDO;
import com.zimug.bootlaunch.dao.testdb.ArticleRepository;
import com.zimug.bootlaunch.dao.testdb2.Message;
import com.zimug.bootlaunch.dao.testdb2.MessageRepository;
import com.zimug.bootlaunch.pojo.ArticleVO;
import com.zimug.bootlaunch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author FairyLand
 */
@Slf4j
@Service
public class ArticleRestJPAServiceImpl implements  ArticleRestJPAService  {

    /* 将JPA仓库对象注入 */

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Resource
    MessageRepository messageRepository;

    @Transactional
    @Override
    public ArticleVO saveArticle( ArticleVO article) {
        log.info(article.toString());
        ArticleDO articleDO = dozerMapper.map(article,ArticleDO.class);
        //保存一个对象到数据库，insert
        log.info(articleDO.toString());
//        articleDO.setCreateTime(LocalDateTime.now());
        articleRepository.save(articleDO);


        Message message = new Message();
        message.setName("库里");
        message.setContent("萌神");
        messageRepository.save(message);
//        int i= 1/0;

        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        //根据id删除1条数据库记录
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        ArticleDO articleDO = dozerMapper.map(article,ArticleDO.class);
        //更新一个对象到数据库，仍然使用save方法
        articleRepository.save(articleDO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<ArticleDO> article;  //根据id查找一条数据
        article = articleRepository.findById(id);
        return dozerMapper.map(article.get(),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        //查询article表的所有数据
//        List<ArticleDO> articleLis = articleRepository.findAll();


        Pageable pageable = PageRequest.of(1, 3);   //第一页
//Pageable pageable = PageRequest.of(0, 10);  //第二页
//Pageable pageable = PageRequest.of(0, 10);  // 第三页
//数据库操作获取查询结果
        Page<ArticleDO> articlePage = articleRepository.findAll(pageable);
//将查询结果转换为List
        List<ArticleDO> articleLis = articlePage.getContent();
        return DozerUtils.mapList(articleLis,ArticleVO.class);
    }


}
