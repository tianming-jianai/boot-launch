package com.zimug.bootlaunch.pojo.yaml;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Friends {
    private String hobby;
    private String sex;
}
