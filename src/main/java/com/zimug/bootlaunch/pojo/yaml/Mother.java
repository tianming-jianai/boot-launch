package com.zimug.bootlaunch.pojo.yaml;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Mother {
    private List<String> alias;
}
