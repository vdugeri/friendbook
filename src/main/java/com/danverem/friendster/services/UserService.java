package com.danverem.friendster.services;

import com.danverem.friendster.dtos.UserDTO;
import com.danverem.friendster.mappers.UserMapper;
import com.danverem.friendster.repositories.UserRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<UserDTO> all() {
        return UserMapper.mapTo(userRepository.findAll());
    }

    public Optional<UserDTO> findOne(Long ID) {
        return Optional.ofNullable(UserMapper.mapTo(userRepository.find(ID)));
    }

    public UserDTO save(UserDTO userDTO) {
        return UserMapper.mapTo(userRepository.create(UserMapper.mapTo(userDTO)));
    }

    public UserDTO update(UserDTO userDTO) {
        return UserMapper.mapTo(userRepository.edit(UserMapper.mapTo(userDTO)));
    }

    public void delete(Long ID) {
        userRepository.delete(ID);
    }
}
