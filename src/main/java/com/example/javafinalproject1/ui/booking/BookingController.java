package com.example.javafinalproject1.ui.booking;

import com.example.javafinalproject1.SceneManager;
import com.example.javafinalproject1.DataStorage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class BookingController {
    @FXML private TextField passengerName;
    @FXML private TextField passportId;
    @FXML private Label successLabel;

    @FXML
    public void confirmPurchase() {
        if (!passengerName.getText().isEmpty()) {
            DataStorage.bookedTickets.add("Билет: " + passengerName.getText());
            successLabel.setText("Успешно забронировано!");
            successLabel.setStyle("-fx-text-fill: #34C759;");
        }
    }

    @FXML
    public void goToSearch() throws IOException {
        SceneManager.switchScene("search.fxml");
    }

    @FXML
    public void cancel() throws IOException {
        SceneManager.switchScene("results.fxml");
    }
}