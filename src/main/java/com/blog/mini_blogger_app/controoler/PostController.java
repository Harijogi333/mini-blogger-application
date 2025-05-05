package com.blog.mini_blogger_app.controoler;

import com.blog.mini_blogger_app.dto.PostRequestDto;
import com.blog.mini_blogger_app.dto.PostResponse;
import com.blog.mini_blogger_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create/post")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequestDto postRequestDto)
    {
        return postService.createPost(postRequestDto);
    }

}
