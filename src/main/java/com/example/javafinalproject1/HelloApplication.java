package com.example.javafinalproject1;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.switchScene("login.fxml");
        stage.setTitle("Transport Booking System");
        stage.setMinWidth(600);
    }
    public static void main(String[] args) {
        launch();
    }
}