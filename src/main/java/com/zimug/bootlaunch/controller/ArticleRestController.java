package com.zimug.bootlaunch.controller;


import com.zimug.bootlaunch.pojo.ArticleVO;
import com.zimug.bootlaunch.service.ArticleMyBatisRestService;
import com.zimug.bootlaunch.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
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
    ArticleMyBatisRestService articleRestService;

    /**
     * 增加一篇Article ，使用POST方法
     *
     * @param article 文章
     * @return AjaxResponse
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", article);
        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id 文章编号
     * @return AjaxResponse
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}", id);
        articleRestService.deleteArticle(id);
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
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);
        log.info("updateArticle：{}", article);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    /**
     * 获取一篇Article，使用GET方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {
        ArticleVO article = articleRestService.getArticle(id);
        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getAll() {
        List<ArticleVO> all = articleRestService.getAll();
        return AjaxResponse.success(all);
    }
}
