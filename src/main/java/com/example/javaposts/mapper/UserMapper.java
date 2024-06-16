package com.example.javaposts.mapper;

import com.example.javaposts.DTO.UserDTO;
import com.example.javaposts.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOList(List<User> userList);
}
