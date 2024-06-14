package com.example.javaposts.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record UserDTO(
        long id,
        String username,
        String email
) {
}
