package com.example.javaposts.controller;

import com.example.javaposts.DTO.UserDTO;
import com.example.javaposts.entity.User;
import com.example.javaposts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserDTO> getUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/email")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserDTO> getUserByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
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
