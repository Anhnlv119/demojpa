package com.vuanh.demojpa.service;

import com.vuanh.demojpa.dto.UserDTO;
import com.vuanh.demojpa.entity.Roles;
import com.vuanh.demojpa.entity.Users;
import com.vuanh.demojpa.payload.LoginRequest;
import com.vuanh.demojpa.reponsitory.UserReponsitory;
import com.vuanh.demojpa.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public boolean login(LoginRequest loginRequest) {
        return userReponsitory.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).size() > 0;

    }

    @Override
    public boolean insertUser(UserDTO userDTO){
        Roles roles = new Roles();
        roles.setId(userDTO.getRoleId());

        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setFullName(userDTO.getFullName());
        users.setAvatar(userDTO.getAvatar());
        users.setRoles(roles);

        try{
            userReponsitory.save(users);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<UserDTO> getAllUser(){
        List<UserDTO> list = new ArrayList<>();
        for (Users users :userReponsitory.getAllUser()){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(users.getEmail());
            userDTO.setPassword(users.getPassword());
            userDTO.setFullName(users.getFullName());
            userDTO.setAvatar(users.getAvatar());

            list.add(userDTO);
        }
        return list;
    }

    @Override
    public List<UserDTO> getUserByEmailAndRoleName(String email, String roleName) {
        List<UserDTO> list = new ArrayList<>();
        for (Users users :userReponsitory.getUserByEmailAndRoleName(email,roleName)){
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(users.getEmail());
            userDTO.setPassword(users.getPassword());
            userDTO.setFullName(users.getFullName());
            userDTO.setAvatar(users.getAvatar());

            list.add(userDTO);
        }
        return list;
    }
}
