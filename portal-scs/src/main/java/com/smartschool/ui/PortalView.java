package com.smartschool.ui;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Portal SCS")
public class PortalView extends VerticalLayout {

    public PortalView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new H2("Bem-vindo ao Portal SCS"));
        add(new Span("Use o menu à esquerda para navegar entre os módulos."));
    }
}
