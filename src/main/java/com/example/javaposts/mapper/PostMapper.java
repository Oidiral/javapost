package com.example.javaposts.mapper;

import com.example.javaposts.DTO.PostDTO;
import com.example.javaposts.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO toPostDTO(Post post);
    Post toPost(PostDTO postDTO);
    List<PostDTO> toPostDTOList(List<Post> posts);
}
