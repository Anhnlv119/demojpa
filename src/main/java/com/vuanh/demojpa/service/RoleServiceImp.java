package com.vuanh.demojpa.service;

import com.vuanh.demojpa.dto.RoleDTO;
import com.vuanh.demojpa.entity.Roles;
import com.vuanh.demojpa.reponsitory.RoleReponsitory;
import com.vuanh.demojpa.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleReponsitory roleReponsitory;

    @Override
    public List<RoleDTO> getAllRole() {
        List<Roles> list =roleReponsitory.findAll();
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data : list){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);
        }
        return  dtoList;
    }

    @Override
    public List<RoleDTO> getRoleByName(String name) {
        List<Roles> list =roleReponsitory.findByName(name);
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data : list){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);
        }
        return  dtoList;
    }
}
