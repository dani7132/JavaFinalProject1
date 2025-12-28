package com.example.javafinalproject1.ui.search;

import com.example.javafinalproject1.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.IOException;

public class SearchController {
    @FXML private TextField fromField;
    @FXML private TextField toField;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> transportType;

    @FXML
    public void initialize() {
        if (transportType != null && transportType.getItems().isEmpty()) {
            transportType.getItems().addAll("Самолет ✈️", "Поезд 🚂", "Автобус 🚌");
        }
    }

    @FXML
    public void onSearch() throws IOException {
        SceneManager.switchScene("results.fxml");
    }

    @FXML
    public void viewReservations() throws IOException {
        SceneManager.switchScene("reservations.fxml");
    }

    @FXML
    public void goBack() throws IOException {
        SceneManager.switchScene("login.fxml");
    }
}