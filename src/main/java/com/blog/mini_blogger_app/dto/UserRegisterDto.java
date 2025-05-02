package com.blog.mini_blogger_app.dto;

import lombok.Data;

@Data
public class UserRegisterDto {

    private String userName;
    private String email;
    private String password;
}
