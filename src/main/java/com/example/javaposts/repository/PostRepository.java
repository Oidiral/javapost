package com.example.javaposts.repository;

import com.example.javaposts.entity.Post;
import com.example.javaposts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository
        extends JpaRepository<Post, Long> {

    List<Post> findByContentContainsIgnoreCaseOrTitleContainingIgnoreCase(String content, String title);

    List<Post> getPostsByAuthor_Id(Long id);
}

