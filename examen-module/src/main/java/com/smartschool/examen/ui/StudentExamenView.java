package com.smartschool.examen.ui;

import com.smartschool.examen.ExamenDTO;
import com.smartschool.examen.ExamenService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("student-examens")
@PageTitle("Exames do Estudante")
public class StudentExamenView extends VerticalLayout {

    private final TextField emailField = new TextField("Email do estudante");
    private final Button searchButton = new Button("Buscar");
    private final Grid<ExamenDTO> examenGrid = new Grid<>(ExamenDTO.class);

    private final ExamenService examenService;

    public StudentExamenView(ExamenService examenService) {
        this.examenService = examenService;

        configureGrid();
        configureSearch();

        add(new H2("Exames do Estudante"), emailField, searchButton, examenGrid);
    }

    private void configureGrid() {

        examenGrid.removeAllColumns();

        examenGrid.addColumn(ExamenDTO::getSubject).setHeader("Matéria");
        examenGrid.addColumn(ExamenDTO::getDate).setHeader("Data");
        examenGrid.addColumn(ExamenDTO::getScore).setHeader("Nota");

        setSizeFull();
        examenGrid.setSizeFull();
    }

    private void configureSearch() {
        searchButton.addClickListener(e -> {
            String email = emailField.getValue();
            if (email != null && !email.isEmpty()) {
                List<ExamenDTO> examens = examenService.getExamensByStudentEmail(email);
                if (examens.isEmpty()) {
                    Notification.show("Nenhum exame encontrado para esse estudante.");
                } else {
                    examenGrid.setItems(examens);
                }
            } else {
                Notification.show("Informe um email válido");
            }
        });
    }
}
