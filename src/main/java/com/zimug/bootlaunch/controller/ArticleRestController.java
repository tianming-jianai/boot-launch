package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.dao.ArticleDao;
import com.zimug.bootlaunch.pojo.Article;
import com.zimug.bootlaunch.server.ArticleRestService;
import com.zimug.bootlaunch.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shiga
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    ArticleRestService articleRestService;

    @Resource
    ArticleDao mongoRepository;

    @Resource
    MongoTemplate mongoTemplate;

    /**
     * 增加一篇Article ，使用POST方法
     *
     * @param article 文章
     * @return AjaxResponse
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", article);
        mongoRepository.save(article);
        return AjaxResponse.success(article);
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id 文章编号
     * @return AjaxResponse
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable String id) {
        log.info("deleteArticle：{}", id);
        mongoRepository.deleteById(id);
        return AjaxResponse.success(id);
    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param id
     * @param article
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}", article);
        mongoRepository.save(article);
        return AjaxResponse.success(article);
    }

    /**
     * 获取一篇Article，使用GET方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable String id) {

//        Optional<Article> article = mongoRepository.findById(id);
//        Article article = mongoRepository.findByAuthor(id);

        //查找 article根据Criteria 改造查询条件
        Query query = new Query(Criteria.where("author").is("wishisnotfar"));
        List<Article> article = mongoTemplate.find(query,Article.class);
        return AjaxResponse.success(article.get(0));
    }

    @GetMapping(value = "/article")
    public AjaxResponse getAll(){
        List all = mongoRepository.findAll();
        return AjaxResponse.success(all);
    }
}
