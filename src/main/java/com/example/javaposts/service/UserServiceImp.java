package com.example.javaposts.service;

import com.example.javaposts.DTO.UserDTO;
import com.example.javaposts.entity.User;
import com.example.javaposts.exception.NotFoundException;
import com.example.javaposts.mapper.UserMapper;
import com.example.javaposts.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.toUserDTO(userRepository.save(userMapper.toUser(userDTO)));
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDTO)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

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

    @Override
    public UserDTO findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toUserDTO)
                .orElseThrow(() -> new NotFoundException("User not found with username: " + username));
    }
}
