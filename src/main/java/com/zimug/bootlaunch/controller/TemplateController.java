package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.pojo.ArticleVO;
import com.zimug.bootlaunch.service.ArticleMyBatisRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name="articleMyBatisRestServiceImpl")
    ArticleMyBatisRestService articleMyBatisRestService;

    @GetMapping("/jsp")
    public String index(String name, Model model) {

        List<ArticleVO> articles = articleMyBatisRestService.getAll();

        model.addAttribute("articles", articles);

        //模版名称，实际的目录为：src/main/webapp/WEB-INF/jsp/jsptemp.jsp
        return "jsptemp";
    }

    @GetMapping("/freemarker")
    public String index(Model model) {

        List<ArticleVO> articles = articleMyBatisRestService.getAll();

        model.addAttribute("articles", articles);

        //模版名称，实际的目录为：resources/templates/fremarkertemp.html
        return "freemarkertemp";
    }

    @GetMapping("/thymeleaf")
    public String index2(Model model, HttpSession session) {

        List<ArticleVO> articles = articleMyBatisRestService.getAll();

        model.addAttribute("articles", articles);

        Map<String,Object> user = new HashMap<>();
        user.put("id","1");
        user.put("username",null);
        user.put("password","m123");
        model.addAttribute("user",user);

        session.setAttribute("foo","22222222");

        //模版名称，实际的目录为：resources/templates/thymeleaftemp.html
        return "thymeleaftemp";
    }
}