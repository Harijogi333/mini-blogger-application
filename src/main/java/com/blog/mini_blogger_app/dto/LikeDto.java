package com.blog.mini_blogger_app.dto;

import com.blog.mini_blogger_app.entity.Post;
import com.blog.mini_blogger_app.entity.User;
import lombok.Data;

@Data
public class LikeDto {

    private int userId;
    private int postId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
