package com.danverem.friendster.mappers;

import com.danverem.friendster.dtos.UserDTO;
import com.danverem.friendster.models.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapTo(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setFirstName(userDTO.getFirstName());
        user.setID(userDTO.getID());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());


        return user;
    }

    public static UserDTO mapTo(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setEmailAddress(user.getEmailAddress());
        dto.setFirstName(user.getFirstName());
        dto.setID(user.getID());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());

        return dto;
    }

    public static List<UserDTO> mapTo(List<User> users) {
        if (users.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return users.stream().map(user -> mapTo(user)).collect(Collectors.toList());
    }
}
