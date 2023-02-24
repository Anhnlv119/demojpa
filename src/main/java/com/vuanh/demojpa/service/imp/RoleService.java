package com.vuanh.demojpa.service.imp;

import com.vuanh.demojpa.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRole();
    List<RoleDTO> getRoleByName(String name);
}
