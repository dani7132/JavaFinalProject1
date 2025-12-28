package com.example.javafinalproject1.ui.reservations;

import com.example.javafinalproject1.SceneManager;
import com.example.javafinalproject1.DataStorage;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;

public class ReservationsController {
    @FXML private ListView<String> reservationsList;

    @FXML
    public void initialize() {
        reservationsList.setItems(DataStorage.bookedTickets);
    }

    @FXML
    public void goToSearch() throws IOException {
        SceneManager.switchScene("search.fxml");
    }
}