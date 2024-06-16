package com.example.javaposts.DTO;

import com.example.javaposts.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO{
    long id;
    String title;
    String content;
    User author;
}
