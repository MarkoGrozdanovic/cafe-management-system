package com.cafe.service;

import com.cafe.model.DTO.UserDTO;
import com.cafe.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    UserDTO addNewUser(UserDTO user);

//    UserDTO updateUser(UserDTO user, long id);
}
