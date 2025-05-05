package com.blog.mini_blogger_app.dto;

import com.blog.mini_blogger_app.entity.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;

public class UserResponseDto {

    private String userName;
    private String email;
    private Set<Role> roles;
    private List<PostResponse> posts;
    private List<CommentDto> coments;
    private List<LikeDto> likes;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<PostResponse> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResponse> posts) {
        this.posts = posts;
    }

    public List<CommentDto> getComents() {
        return coments;
    }

    public void setComents(List<CommentDto> coments) {
        this.coments = coments;
    }

    public List<LikeDto> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDto> likes) {
        this.likes = likes;
    }
}
