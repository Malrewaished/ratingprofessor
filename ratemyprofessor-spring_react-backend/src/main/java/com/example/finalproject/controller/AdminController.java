package com.example.finalproject.controller;
import com.example.finalproject.dto.Api;
import com.example.finalproject.model.Admin;
import com.example.finalproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity getAdmin() {
        return ResponseEntity.status(200).body(adminService.getAdmin());
    }

    @PostMapping("/login")
    public ResponseEntity<?> logInAdmin(@RequestBody Admin admin) {
        try {
            return ResponseEntity.ok(adminService.loginAsAdmin(admin));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
