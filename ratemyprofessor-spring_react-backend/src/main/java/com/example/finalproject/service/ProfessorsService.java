package com.example.finalproject.service;

import com.example.finalproject.model.Professors;
import com.example.finalproject.repository.ProfessorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorsService {

    private final ProfessorsRepository professorsRepository;

    public List<Professors> getProfessors() {

        return professorsRepository.findAll();

    }

    public Optional<Professors> findById(Integer id) {
        return professorsRepository.findById(id);
    }

//    public void findProfessorsByUniversityName(String universityName) {
//        professorsRepository.findProfessorsByUniversityName(universityName);
//    }
}
