package com.vuanh.demojpa.reponsitory;

import com.vuanh.demojpa.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleReponsitory extends JpaRepository<Roles, Integer> {
    List<Roles> findByName(String name);
}
