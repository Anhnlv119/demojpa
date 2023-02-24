package com.vuanh.demojpa.service.imp;

import com.vuanh.demojpa.dto.UserDTO;
import com.vuanh.demojpa.payload.LoginRequest;

import java.util.List;

public interface UserService {
    boolean login(LoginRequest loginRequest);
    boolean insertUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    List<UserDTO> getUserByEmailAndRoleName(String email, String roleName);
}
