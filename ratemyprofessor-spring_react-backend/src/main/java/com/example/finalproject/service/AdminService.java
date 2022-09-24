package com.example.finalproject.service;
import com.example.finalproject.model.Admin;
import com.example.finalproject.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor

public class AdminService {

    private final AdminRepository adminRepository;
    public List<Admin> getAdmin() {

        return adminRepository.findAll();
    }

    public Admin loginAsAdmin(Admin admin)throws Exception {
        Admin findAdmin = adminRepository.findAdmin(admin.getEmail(), admin.getPassword());
        if(findAdmin==null)
            throw new Exception("Password or username is incorrect");
        return findAdmin;
    }
}
