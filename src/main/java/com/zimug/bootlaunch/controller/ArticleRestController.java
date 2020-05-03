package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.pojo.ArticleVO;
import com.zimug.bootlaunch.service.ArticleRestJPAService;
import com.zimug.bootlaunch.utils.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shiga
 */
@Slf4j
@RestController
@RequestMapping("/rest2")
public class ArticleRestController {

    @Resource
    ArticleRestJPAService articleRestJPAServiceImpl;

    /**
     * 增加一篇Article ，使用POST方法
     *
     * @param articleVO 文章
     * @return AjaxResponse
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public AjaxResponse saveArticle(@RequestBody ArticleVO articleVO) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", articleVO);
        articleRestJPAServiceImpl.saveArticle(articleVO);
        return AjaxResponse.success(articleVO);
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
        articleRestJPAServiceImpl.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param id
     * @param articleVO
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO articleVO) {
        articleVO.setId(id);
        log.info("updateArticle：{}", articleVO);
        articleRestJPAServiceImpl.updateArticle(articleVO);
        return AjaxResponse.success(articleVO);
    }

    /**
     * 获取一篇Article，使用GET方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {

        //使用lombok提供的builder构建对象
        ArticleVO articleVO1 = ArticleVO.builder()
                .id(1L)
                .author("zimug")
                .content("spring boot 2.深入浅出")
                .createTime(LocalDateTime.now())
                .title("t1").build();
        articleVO1 = articleRestJPAServiceImpl.getArticle(id);
        return AjaxResponse.success(articleVO1);
    }

    @GetMapping("/article")
    public AjaxResponse getAll(){
        List<ArticleVO> all = articleRestJPAServiceImpl.getAll();
        return AjaxResponse.success(all);
    }
}
