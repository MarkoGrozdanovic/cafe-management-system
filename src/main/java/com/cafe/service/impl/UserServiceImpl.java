package com.cafe.service.impl;

import com.cafe.model.DTO.UserDTO;
import com.cafe.model.User;
import com.cafe.model.enums.ROLES;
import com.cafe.repository.UserRepository;
import com.cafe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO addNewUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUserName(username);

        return user.orElseThrow(() -> new RuntimeException("User not found with username: "+username));
    }

//    @Override
//    public UserDTO updateUser(UserDTO userDTO, long id) {
//        User user = userRepository.findById(id).orElseThrow(()
//                -> new RuntimeException("Note not found"));
//
//        user.setEmail(userDTO.getEmail());
//        user.setName(userDTO.getName());
//        user.setRole(ROLES.valueOf(userDTO.getRole()));
//        user.setPassword(userDTO.getPassword());
//
//        User savedUser = userRepository.save(user);
//
//        return modelMapper.map(user, UserDTO.class);
//    }
}
