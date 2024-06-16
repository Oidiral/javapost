package com.example.javaposts.DTO;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{

    @Null
    private long id;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
