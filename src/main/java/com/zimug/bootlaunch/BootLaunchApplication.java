package com.zimug.bootlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 张世罡
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
//@MapperScan(basePackages = {"com.zimug.bootlaunch.generator"})
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
