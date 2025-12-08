package com.cafe.controller;

import com.cafe.model.User;
import com.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<?> updateUserRole(@AuthenticationPrincipal UserDetails userDetails, @RequestParam String role){
            userService.updateUserRole(userDetails.getUsername(), role);
            return ResponseEntity.ok("User role updated!!!");
    }

//            updateUserRole
//
//    getUser
}
