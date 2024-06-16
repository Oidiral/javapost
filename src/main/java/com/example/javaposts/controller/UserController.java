package com.example.javaposts.controller;

import com.example.javaposts.DTO.UserDTO;
import com.example.javaposts.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {


    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/username/{username}")
    public UserDTO getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        log.info("Received UserDTO: {}", userDTO);
        System.err.println("Received UserDTO: " + userDTO);
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserDTO user, @PathVariable Long userId) {
        userService.updateUser(userId, user);
    }
}