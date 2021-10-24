package com.example.demo.controllers;

import com.example.demo.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    private PostService postService;

    @Autowired
    public void PostsController(PostService postService) {
        this.postService = postService;
    }

}
