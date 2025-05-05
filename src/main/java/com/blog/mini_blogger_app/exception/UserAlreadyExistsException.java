package com.blog.mini_blogger_app.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message)
    {
        super(message);
    }
}

