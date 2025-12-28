package com.example.javafinalproject1.ui.login;

import com.example.javafinalproject1.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class RegisterController {

    @FXML private TextField regUsernameField;
    @FXML private PasswordField regPasswordField;
    @FXML private Label statusLabel;

    @FXML
    public void handleRegisterClick() {
        if (!regUsernameField.getText().isEmpty() && !regPasswordField.getText().isEmpty()) {
            statusLabel.setText("Вы успешно зарегистрировались!");
            statusLabel.setStyle("-fx-text-fill: green;");
        } else {
            statusLabel.setText("Заполните все поля!");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void handleBack() throws IOException {
        SceneManager.switchScene("login.fxml");
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}