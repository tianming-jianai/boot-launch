package com.zimug.bootlaunch.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shiga
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value={"name","age"})
public class Friend {
    @JsonProperty("name")
    private String nickname;
    private int age;
}
