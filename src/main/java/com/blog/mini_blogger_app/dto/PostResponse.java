package com.blog.mini_blogger_app.dto;


import com.blog.mini_blogger_app.entity.User;
import lombok.Data;

@Data
public class PostResponse {

    private String title;
    private String content;
    private int userId;
    private int commentCount;
    private int likesCount;

}
