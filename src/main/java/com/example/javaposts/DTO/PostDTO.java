package com.example.javaposts.DTO;

import com.example.javaposts.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostDTO{
    long id;
    String title;
    String content;
    User author;
}
