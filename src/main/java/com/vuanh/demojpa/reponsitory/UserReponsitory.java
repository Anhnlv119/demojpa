package com.vuanh.demojpa.reponsitory;

import com.vuanh.demojpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReponsitory extends JpaRepository<Users, Integer> {
    List<Users > findByEmailAndPassword(String email, String password);

    @Query("select a from users as a")
    List<Users> getAllUser();

    @Query("select u from users as u join roles r on u.roles.id = r.id where u.email = ?1 and r.name = ?2")
    public  List<Users> getUserByEmailAndRoleName(String email, String roleName);
}
