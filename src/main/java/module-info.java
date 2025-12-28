module com.example.javafinalproject1 {
admin-ui
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
=======

    requires javafx.controls;
    requires javafx.fxml;
 feature-db
    requires java.sql;

    opens com.example.javafinalproject1 to javafx.fxml;
=======

    opens com.example.javafinalproject1 to javafx.fxml;
    opens com.example.javafinalproject1.ui.login to javafx.fxml; // Оставляем эту
    opens com.example.javafinalproject1.ui.search to javafx.fxml;
    opens com.example.javafinalproject1.ui.results to javafx.fxml;
    opens com.example.javafinalproject1.ui.booking to javafx.fxml;
    opens com.example.javafinalproject1.ui.reservations to javafx.fxml;

 master

    exports com.example.javafinalproject1;
    exports com.example.javafinalproject1.model;
}
 feature-db
