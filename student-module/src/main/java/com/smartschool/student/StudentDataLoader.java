package com.smartschool.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentDataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public StudentDataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        if (studentRepository.count() == 0) {
            studentRepository.saveAll(Arrays.asList(
                    new Student("ABCC", "Carl Test", "student1@school.com", "123"),
                    new Student("BCCD","Anna", "anna.martinez@example.com", "345"),
                    new Student("CCDE", "Liam", "liam.nguyen@example.com", "4567"),
                    new Student("DDEF", "Sophie", "sophie.dubois@example.com", "5678")
            ));
        }
    }
}

