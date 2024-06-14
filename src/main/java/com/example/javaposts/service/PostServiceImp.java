package com.example.javaposts.service;

import com.example.javaposts.entity.Post;
import com.example.javaposts.entity.Role;
import com.example.javaposts.entity.User;
import com.example.javaposts.exception.NotCorrectUser;
import com.example.javaposts.exception.NotFoundException;
import com.example.javaposts.repository.PostRepository;
import com.example.javaposts.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Post addPost(Post post, Long userId) {
        User author = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        post.setAuthor(author);
        postRepository.save(post);
        return post;
    }

    @Transactional
    @Override
    public Post updatePost(Post post, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        Post updatedPost = postRepository.findById(post.getId()).orElseThrow(() -> new NotFoundException("Post not found"));
        if (user != updatedPost.getAuthor()) {
            throw new NotCorrectUser("You are not the author of this post");
        }
        if (post.getTitle() != null){
            updatedPost.setTitle(post.getTitle());
        }
        if (post.getContent() != null){
            updatedPost.setContent(post.getContent());
        }
        return postRepository.save(updatedPost);
    }

    @Transactional
    @Override
    public void deletePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));
        if (user != post.getAuthor()) {
            throw new NotCorrectUser("You are not the author of this post");
        }
        postRepository.delete(post);
    }

    @Transactional
    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
    }


    @Transactional
    @Override
    public List<Post> getPostsByUser(Long userId) {
        return postRepository.getPostsByAuthor_Id(userId);
    }

    @Override
    public List<Post> getPosts(Long adminId) throws BadRequestException {
        if (userRepository.getById(adminId).getRole() != Role.ADMIN) {
            throw new BadRequestException("You not admin");
        }
        List<Post> post = new ArrayList<>();
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable page = PageRequest.of(0, 1, sort);
        Page<Post> userPage = postRepository.findAll(page);
        if (userPage.hasContent()) {
            post.addAll(userPage.getContent());
        }
        return post;
    }

    @Override
    public List<Post> getPostsByNameAsc() {
        return List.of();
    }

    @Override
    public List<Post> findPostsByNameDesc() {
        return List.of();
    }
}
