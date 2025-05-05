package com.blog.mini_blogger_app.controoler;

import com.blog.mini_blogger_app.dto.UserLoginDto;
import com.blog.mini_blogger_app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/loggedin")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto,HttpServletRequest request)
    {
        return userService.login(userLoginDto,request);
    }
}

