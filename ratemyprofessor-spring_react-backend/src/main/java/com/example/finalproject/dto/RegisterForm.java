package com.example.finalproject.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterForm {

    private String nickName;
    private String email;
    private String password;
//    private String confirmPassword;
    private String role;

}