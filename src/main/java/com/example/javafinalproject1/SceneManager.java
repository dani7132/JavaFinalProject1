package com.example.javafinalproject1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class SceneManager {
    private static Stage stage;

    public static void setStage(Stage s) {
        stage = s;
    }

    public static void switchScene(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/com/example/javafinalproject1/fxml/" + fxmlFile));
        Scene scene = new Scene(loader.load(), 800, 600);

        URL css = SceneManager.class.getResource("/com/example/javafinalproject1/css/main.css");
        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        }

        stage.setScene(scene);
        stage.show();
    }
}