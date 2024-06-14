package com.example.javaposts.controller;

import com.example.javaposts.entity.Post;
import com.example.javaposts.repository.PostRepository;
import com.example.javaposts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/posts")

public class PostController {

    private final PostService postService;


    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post, @PathVariable final Long userId) {
        return postService.addPost(post, userId);
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Post updatePost(@RequestBody final Post post, @PathVariable final Long userId) {
        return postService.updatePost(post, userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable final Long userId, @RequestBody final Long postId) {
        postService.deletePost(userId, postId);
    }
}

