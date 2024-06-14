package com.example.javaposts.service;

import com.example.javaposts.DTO.UserDTO;
import com.example.javaposts.entity.User;
import com.example.javaposts.exception.NotFoundException;
import com.example.javaposts.mapper.UserMapper;
import com.example.javaposts.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDTO(savedUser);
    }

    @Transactional
    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(userMapper::toUserDTO)
                .map(Optional::of)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }


    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Transactional
    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User userToUpdate = userMapper.toUser(userDTO);
        if (userRepository.existsById(id)) {
            userToUpdate.setId(id);
            userRepository.save(userToUpdate);
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Transactional
    @Override
    public Optional<UserDTO> findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(userMapper::toUserDTO)
                .map(Optional::of)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Transactional
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
