package com.cafe.controller;

import com.cafe.model.DTO.UserDTO;
import com.cafe.model.User;
import com.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping("/updateUserRole")
    public ResponseEntity<?> updateUserRole(@RequestParam Long id, @RequestParam String role){
        System.out.println("ID ROLE: "+id + " - "+role);
            userService.updateUserRole(id, role);
            return ResponseEntity.ok("User role updated!!!");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id),
                HttpStatus.OK);
    }
}
