package com.zimug.bootlaunch.pojo;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章
 *
 * @author shiga
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"content", "title"})
public class ArticleVO {

    @JsonIgnore
    private Long id;

    @JsonProperty("auther")
    private String author;
    private String title;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createTime;
    private List<Reader> reader;

}
