module com.example.javafinalproject1 {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql; // необходимо для работы с БД (DAO)


        // Разрешаем JavaFX искать FXML файлы в основном пакете
        opens com.example.javafinalproject1 to javafx.fxml;

        // ВАЖНО: Разрешаем JavaFX доступ к вашим админским контроллерам
        opens com.example.javafinalproject1.admin.controller to javafx.fxml;

        exports com.example.javafinalproject1;
        exports com.example.javafinalproject1.admin.controller;
    // Это позволит таблицам читать данные из ваших объектов
        opens com.example.javafinalproject1.model to javafx.base;
        }
