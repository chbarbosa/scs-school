package com.smartschool.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Portal SCS");
        logo.getStyle().set("font-size", "var(--lumo-font-size-xl)");

        HorizontalLayout header = new HorizontalLayout(logo);
        header.setWidthFull();
        header.setPadding(true);
        header.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        Anchor estudanteLink = new Anchor("http://localhost:8081", "Examen");
        estudanteLink.getElement().getStyle().set("cursor", "pointer");
        estudanteLink.setTarget("_self"); // se quiser abrir em nova aba

        Anchor examenLink = new Anchor("http://localhost:8082", "Estudante");
        examenLink.getElement().getStyle().set("cursor", "pointer");
        examenLink.setTarget("_self"); // se quiser abrir em nova aba

        addToDrawer(new VerticalLayout(estudanteLink, examenLink));
    }
}
