package com.cafe.controller;

import com.cafe.model.DTO.UserDTO;
import com.cafe.model.User;
import com.cafe.model.response.UserResponse;
import com.cafe.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        List<UserResponse> userResponses = users.stream().map( user -> modelMapper.map(user, UserResponse.class)).toList();

        return ResponseEntity.ok().body(userResponses);
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO user){
            return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

//    @PutMapping("/updateUser/{id}")
//    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user, @PathVariable Long id){
//            return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
//    }
}
