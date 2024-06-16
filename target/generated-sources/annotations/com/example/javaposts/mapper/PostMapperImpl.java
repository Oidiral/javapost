package com.example.javaposts.mapper;

import com.example.javaposts.DTO.PostDTO;
import com.example.javaposts.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T19:42:42+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDTO toPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( post.getId() );
        postDTO.setTitle( post.getTitle() );
        postDTO.setContent( post.getContent() );
        postDTO.setAuthor( post.getAuthor() );

        return postDTO;
    }

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.id( postDTO.getId() );
        post.title( postDTO.getTitle() );
        post.content( postDTO.getContent() );
        post.author( postDTO.getAuthor() );

        return post.build();
    }

    @Override
    public List<PostDTO> toPostDTOList(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( posts.size() );
        for ( Post post : posts ) {
            list.add( toPostDTO( post ) );
        }

        return list;
    }
}
