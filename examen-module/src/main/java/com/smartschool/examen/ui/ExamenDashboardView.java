package com.smartschool.examen.ui;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("examen-dashboard")
public class ExamenDashboardView extends VerticalLayout {

    //private final List<Student> receivedStudents = new ArrayList<>();
    //private final Grid<Student> grid = new Grid<>(Student.class);

    public ExamenDashboardView() {
        //grid.setColumns("firstName", "lastName", "email");
        //grid.setItems(receivedStudents);
        add(new H2("Received Students from student-module"));
    }

    // Add method later to update this list from the event listener
}

