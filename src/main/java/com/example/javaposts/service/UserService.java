package com.example.javaposts.service;

import com.example.javaposts.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO findById(Long id);

    void deleteById(Long id);

    List<UserDTO> findAll();

    void updateUser(Long id, UserDTO userDTO);

    UserDTO findByUsername(String username);
}

