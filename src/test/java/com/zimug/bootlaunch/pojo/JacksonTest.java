package com.zimug.bootlaunch.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);

        // 写为字符串
//        String text = mapper.writeValueAsString(friend);
        // 写为文件
        mapper.writeValue(new File("friend.json"), friend);
        // 写为字节流
//        byte[] bytes = mapper.writeValueAsBytes(friend);
//        System.out.println(text);
        // 从字符串中读取
//        Friend newFriend = mapper.readValue(text, Friend.class);
        // 从字节流中读取
//        newFriend = mapper.readValue(bytes, Friend.class);
        // 从文件中读取
        Friend newFriend = mapper.readValue(new File("friend.json"), Friend.class);
        System.out.println(newFriend);
    }
}
