package com.example.javaposts.service;


import com.example.javaposts.entity.Post;
import org.apache.coyote.BadRequestException;

import java.util.List;


public interface PostService {
    Post addPost(Post post, Long userId);

    Post updatePost(Post post, Long userId);

    void deletePost(Long userId, Long postId);

    Post getPost(Long id);

    List<Post> getPostsByUser(Long userId);

    List<Post> getPosts(Long adminId) throws BadRequestException;

    List<Post> getPostsByNameAsc();

    List<Post> findPostsByNameDesc();
}
