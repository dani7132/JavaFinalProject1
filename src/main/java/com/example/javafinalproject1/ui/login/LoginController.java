package com.example.javafinalproject1.ui.login;

import com.example.javafinalproject1.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    public void handleLogin() throws IOException {
        // Простая проверка для примера
        if (!usernameField.getText().isEmpty()) {
            SceneManager.switchScene("search.fxml");
        }
    }

    @FXML
    public void goToRegister() throws IOException {
        SceneManager.switchScene("register.fxml");
    }

    @FXML
    public void exitApp() {
        Platform.exit();
    }
}