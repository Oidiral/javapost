package com.example.javaposts;

import com.example.javaposts.mapper.UserMapper;
import com.example.javaposts.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavapostsApplication {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(JavapostsApplication.class, args);
    }
}
