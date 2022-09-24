package com.example.finalproject.repository;

import com.example.finalproject.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query("select admin from Admin admin where admin.email=?1 and admin.password=?2")
    Admin findAdmin(String email, String password);
}

