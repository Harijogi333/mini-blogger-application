package com.blog.mini_blogger_app.dto;

import com.blog.mini_blogger_app.entity.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserResponseDto {

    private String userName;
    private String email;
    private Set<Role> roles;
    private List<PostResponse> posts;
    private List<CommentDto> coments;
    private List<LikeDto> likes;
}
