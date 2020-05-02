package com.zimug.bootlaunch.pojo.yaml;

import com.zimug.bootlaunch.utils.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * // @PropertySource(value = {"classpath:family.yml"}) //对于properties文件只需要这些
 *
 * @author 张世罡
 * @date 2020-04-12
 */
@Data
@Component
@ConfigurationProperties(prefix = "family")
@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
public class Family {
    //    @Value("${family.family-name}")

    @NotNull(message = "家庭名称不可为空")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
