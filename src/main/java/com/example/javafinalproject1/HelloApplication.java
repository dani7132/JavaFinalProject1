package com.example.javafinalproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // ЗАМЕНИТЕ ЭТУ СТРОКУ:
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin/AdminDashboard.fxml"));

        // Укажите размер окна побольше, например 800x600
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Admin Panel - Booking System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}