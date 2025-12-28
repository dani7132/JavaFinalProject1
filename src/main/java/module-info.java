module com.example.javafinalproject1 {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.javafinalproject1 to javafx.fxml;

    exports com.example.javafinalproject1;
    exports com.example.javafinalproject1.model;
}
