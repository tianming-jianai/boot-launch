package com.zimug.bootlaunch.pojo.yaml;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Child {
    private String name;
    private Integer age;
    private List<Friends> friends;
}
