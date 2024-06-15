package com.example.javaposts.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDTO{
    private String username;
    private String email;
    private String password;
}
