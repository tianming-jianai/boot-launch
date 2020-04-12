package com.zimug.bootlaunch.pojo.yaml;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Father {
    private String name;
    private Integer age;
}
