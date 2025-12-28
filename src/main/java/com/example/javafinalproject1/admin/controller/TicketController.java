package com.example.javafinalproject1.admin.controller;

import com.example.javafinalproject1.admin.service.AdminService;
import com.example.javafinalproject1.model.Ticket;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TicketController {

    @FXML private TableView<Ticket> table;
    @FXML private TableColumn<Ticket, Long> colId;
    @FXML private TableColumn<Ticket, Long> colRoute;
    @FXML private TableColumn<Ticket, Number> colSeats;
    @FXML private TableColumn<Ticket, Number> colPrice;

    private final AdminService service = new AdminService();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getId()).asObject());
        colRoute.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getRouteId()).asObject());
        colSeats.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getSeatsLeft()));
        colPrice.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getPrice().doubleValue()));

        table.setItems(FXCollections.observableArrayList(service.getTickets()));
    }

    @FXML
    private void deleteTicket() {
        Ticket t = table.getSelectionModel().getSelectedItem();
        if (t != null) {
            service.deleteTicket(t.getId());
            table.setItems(FXCollections.observableArrayList(service.getTickets()));
        }
    }
}
