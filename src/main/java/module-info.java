module com.example.javafinalproject1 {

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
