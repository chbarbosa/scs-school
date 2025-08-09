package com.smartschool.examen;

import org.springframework.stereotype.Component;
import com.smartschool.shared.dto.StudentDTO;
import org.springframework.jms.annotation.JmsListener;

@Component
public class StudentConsumer {

    @JmsListener(destination = "student-topic")
    public void receive(StudentDTO student) {
        System.out.println("📥 Recebido: " + student.getFirstName() + " " + student.getLastName());
    }
}
