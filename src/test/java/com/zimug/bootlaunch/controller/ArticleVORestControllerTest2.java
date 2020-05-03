package com.zimug.bootlaunch.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@Slf4j
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ArticleVORestControllerTest2 {

    //mock对象
    @Resource
    private MockMvc mockMvc;//=MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();;

    //mock对象初始化
    /*@BeforeAll
    public static void setUp() {
        //tandaloneSetup(Object... controllers): 通过参数指定一组控制器，这样就不需要从上下文获取了。
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }*/

    //测试方法
    @Test
    public void saveArticle() throws Exception {

//        System.out.println(mockMvc);

        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"auther\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                        .contentType("application/json;charset=utf-8").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.auther").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }
}
