package com.vuanh.demojpa.controller;

import com.vuanh.demojpa.dto.UserDTO;
import com.vuanh.demojpa.payload.LoginRequest;
import com.vuanh.demojpa.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/getUserByEmailAndRoleName")
    public ResponseEntity<?> getUserByEmailAndRoleName(
            @RequestParam("email") String email,
            @RequestParam("roleName") String roleName
    ){
        return new ResponseEntity<>(userService.getUserByEmailAndRoleName(email, roleName), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);

        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }
}
