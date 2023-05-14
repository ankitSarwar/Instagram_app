package com.geekster.Instagram.controller;

import com.geekster.Instagram.model.Post;
import com.geekster.Instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/getAll")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @PostMapping("/add")
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }



}
