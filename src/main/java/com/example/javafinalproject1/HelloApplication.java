package com.example.javafinalproject1;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
admin-ui
        // ЗАМЕНИТЕ ЭТУ СТРОКУ:
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin/AdminDashboard.fxml"));

        // Укажите размер окна побольше, например 800x600
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Admin Panel - Booking System");
        stage.setScene(scene);
        stage.show();
=======
        SceneManager.setStage(stage);
        SceneManager.switchScene("login.fxml");
        stage.setTitle("Transport Booking System");
        stage.setMinWidth(600);
feature-db
    }
    public static void main(String[] args) {
        launch();
    }
}