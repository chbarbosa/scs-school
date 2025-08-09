package com.smartschool.student.ui;

import com.smartschool.student.Student;
import com.smartschool.student.StudentRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("my-profile")
@PageTitle("My Profile")
public class StudentView extends VerticalLayout {

    private final StudentRepository studentRepository;

    private final TextField nameField = new TextField("Name");
    private final TextField emailField = new TextField("Email");
    private final TextField phoneField = new TextField("Phone");
    private final TextField studentIdField = new TextField("Student ID");
    private final Button saveButton = new Button("Save");

    public StudentView(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        studentIdField.setReadOnly(true);
        emailField.setReadOnly(true);

        add(new H2("My Profile"), studentIdField, nameField, emailField, phoneField, saveButton);

        loadStudentData();
        configureSaveAction();
    }

    private void loadStudentData() {
        // Simulate logged-in student
        String email = "student1@school.com";
        Student student = studentRepository.findByEmail(email);

        studentIdField.setValue(student.getStudentId());
        nameField.setValue(student.getName());
        emailField.setValue(student.getEmail());
        phoneField.setValue(student.getPhone());
    }

    private void configureSaveAction() {
        saveButton.addClickListener(e -> {
            Student updated = new Student(
                    studentIdField.getValue(),
                    nameField.getValue(),
                    emailField.getValue(),
                    phoneField.getValue()
            );
            studentRepository.save(updated);
            Notification.show("Profile updated successfully!");
        });
    }
}

