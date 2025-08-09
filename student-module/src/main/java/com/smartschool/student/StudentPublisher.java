package com.smartschool.student;

import com.smartschool.shared.dto.StudentDTO;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentPublisher {

    private final JmsTemplate jmsTemplate;

    public StudentPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void publish(StudentDTO student) {
        jmsTemplate.convertAndSend("student-topic", student);
    }
}

