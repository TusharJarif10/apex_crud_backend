//package com.apexcrud.usercrud.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.apexcrud.usercrud.entity.User;
//import com.apexcrud.usercrud.service.UserService;
//
//import jakarta.validation.Valid;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/auth")
//public class RegistrationController {
//
//    @Autowired
//    private UserService userService;
//
//    // Registration endpoint
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
//        userService.registerUser(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    // Login endpoint
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestParam String userid, @RequestParam String password) {
//        Optional<User> user = userService.loginUser(userid, password);
//        if (user.isPresent()) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid user ID or password");
//        }
//    }
//}
