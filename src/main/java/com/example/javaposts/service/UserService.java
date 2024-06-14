package com.example.javaposts.service;

import com.example.javaposts.DTO.UserDTO;
import com.example.javaposts.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO user);

    Optional<UserDTO> findById(Long id);

    void deleteById(Long id);

    List<UserDTO> findAll();

    void updateUser(Long id, UserDTO userDTO);

    Optional<UserDTO> findByEmail(String email);

    Optional<User> findByUsername(String username);

}

