package com.blog.mini_blogger_app.dto;

import com.blog.mini_blogger_app.entity.Post;
import com.blog.mini_blogger_app.entity.User;
import lombok.Data;

@Data
public class CommentDto {

    private String content;
    private int userId;
    private int postId;
}
