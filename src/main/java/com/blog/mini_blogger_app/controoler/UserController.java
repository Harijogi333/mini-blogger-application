package com.blog.mini_blogger_app.controoler;

import com.blog.mini_blogger_app.dto.UserLoginDto;
import com.blog.mini_blogger_app.dto.UserRegisterDto;
import com.blog.mini_blogger_app.dto.UserResponseDto;
import com.blog.mini_blogger_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto)
    {
        return userService.register(userRegisterDto);
    }




}
