package com.zimug.bootlaunch.ymal;

import com.zimug.bootlaunch.pojo.yaml.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomYamlTest {

    @Resource
    Family family;

    @Test
    public void hello() {
        System.out.println(family.toString());
        Jasypt
    }

}
