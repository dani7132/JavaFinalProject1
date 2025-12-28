package com.example.javafinalproject1.admin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private void openUsers() {
        openWindow("Users.fxml", "Users");
    }

    @FXML
    private void openRoutes() {
        openWindow("Routes.fxml", "Routes");
    }

    @FXML
    private void openTickets() {
        openWindow("Tickets.fxml", "Tickets");
    }

    private void openWindow(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/javafinalproject1/admin/" + fxml)
            );
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
