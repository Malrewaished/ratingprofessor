package com.example.finalproject.controller;

import com.example.finalproject.dto.Api;
import com.example.finalproject.dto.RegisterForm;
import com.example.finalproject.model.User;
import com.example.finalproject.service.ProfessorsService;
import com.example.finalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/professors")
public class ProfessorsController {
    private final ProfessorsService professorsService;


    @GetMapping
    public ResponseEntity getProfessors() {
        return ResponseEntity.status(200).body(professorsService.getProfessors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name="id") Integer id) {
        return ResponseEntity.status(200).body(professorsService.findById(id));
    }


//    @PostMapping
//    public ResponseEntity<Api> findProfessorsByUniversityName(@RequestParam @Valid String universityName) {
//        professorsService.findProfessorsByUniversityName(universityName);
//        return ResponseEntity.status(200).body(new Api("Professors found",200));
//    }

}
