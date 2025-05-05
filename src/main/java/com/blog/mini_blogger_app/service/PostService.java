package com.blog.mini_blogger_app.service;

import com.blog.mini_blogger_app.dto.PostRequestDto;
import com.blog.mini_blogger_app.dto.PostResponse;
import com.blog.mini_blogger_app.entity.Post;
import com.blog.mini_blogger_app.entity.User;
import com.blog.mini_blogger_app.repository.PostRepository;
import com.blog.mini_blogger_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<PostResponse> createPost(PostRequestDto postRequestDto)
    {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "+email));
        Post post=postRequestDtoToPost(postRequestDto,user);
        postRepository.save(post);
        PostResponse postResponse=postToPostResponse(post);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);

    }

    private Post postRequestDtoToPost(PostRequestDto postRequestDto,User user)
    {
        Post post=new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        post.setUser(user);
        return post;
    }

    private PostResponse postToPostResponse(Post post)
    {
        PostResponse postResponse=new PostResponse();
        postResponse.setTitle(post.getTitle());
        postResponse.setContent(post.getContent());
        postResponse.setCommentCount(post.getComments().size());
        postResponse.setLikesCount(post.getLikes().size());
        postResponse.setUserId(post.getUser().getId());
        return postResponse;
    }
}
