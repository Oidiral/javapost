package com.example.javaposts.repository;

import com.example.javaposts.entity.Role;
import com.example.javaposts.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveStudent(){
        User user = User.builder()
                .email("olzhas@gmail.com")
                .username("Olzhas")
                .role(Role.USER)
                .build();
    }
}