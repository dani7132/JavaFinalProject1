package com.example.javafinalproject1.ui.results;

import com.example.javafinalproject1.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;

public class ResultsController {
    @FXML private ListView<String> resultsListView;

    @FXML
    public void initialize() {
        resultsListView.getItems().addAll("Рейс А1 - 15:00", "Рейс Б2 - 18:30", "Рейс В3 - 21:00");
    }

    @FXML
    public void goToBooking() throws IOException {
        SceneManager.switchScene("booking.fxml");
    }

    @FXML
    public void goBack() throws IOException {
        SceneManager.switchScene("search.fxml");
    }
}