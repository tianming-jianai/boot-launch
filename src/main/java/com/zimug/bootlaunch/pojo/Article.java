package com.zimug.bootlaunch.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章
 *
 * @author shiga
 */
@Document(collection="article")//集合名
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article  implements Serializable {

    private static final long serialVersionUID = -8985545025018238754L;

//    @Id
    private String id;

    @Indexed
    @JsonProperty("auther")
    private String author;
    private String title;
    @Field("msgContent")
    private String content;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    private List<Reader> reader;


}
