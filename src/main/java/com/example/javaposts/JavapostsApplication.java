package com.example.javaposts;

import com.example.javaposts.entity.Role;
import com.example.javaposts.entity.User;
import com.example.javaposts.mapper.UserMapper;
import com.example.javaposts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavapostsApplication {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(JavapostsApplication.class, args);
    }
}
