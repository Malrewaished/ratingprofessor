package com.example.finalproject.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginForm {
    private String email;
    private String password;
}
