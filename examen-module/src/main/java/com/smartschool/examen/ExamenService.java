package com.smartschool.examen;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class ExamenService {

    public List<ExamenDTO> getExamensByStudentEmail(String email) {
        // Simulação — substitua por chamada REST ou banco
        if (email.equalsIgnoreCase("student1@school.com")) {
            return List.of(
                new ExamenDTO("Matemática", LocalDate.of(2025, 5, 10), 8.5),
                new ExamenDTO("História", LocalDate.of(2025, 6, 2), 9.0)
            );
        }
        return Collections.emptyList();
    }
}
