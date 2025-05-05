package com.blog.mini_blogger_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


public class UserRegisterDto {

    @NotBlank(message = "userName is mandatory")
    @Size(min=3, max=20 , message="userName shoukd be within 3 and 20 characters length")
    private String userName;
    @Email(message="Enter valid mail")
    @NotBlank(message = "mail is madatory")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
