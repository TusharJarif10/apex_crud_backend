package com.apexcrud.usercrud.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apexcrud.usercrud.dto.UserRegistrationDto;
import com.apexcrud.usercrud.entity.User;
import com.apexcrud.usercrud.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    
    //Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    
    //Get all Users 
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String deptmstcode) {
        List<User> users = (deptmstcode == null) 
            ? userService.getAllUsers() 
            : userService.getUsersByDeptmstcode(deptmstcode);
        return ResponseEntity.ok(users);
    }
    

    
    //Create user 
    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody UserRegistrationDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(dto));
    }

    
    
    // Update user by ID
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRegistrationDto dto) {
        return userService.updateUser(id, dto);
    }

    
    
    
    //Delete User by ID 
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    
    
  
}
