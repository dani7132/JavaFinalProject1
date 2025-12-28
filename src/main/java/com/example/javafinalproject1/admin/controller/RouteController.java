package com.example.javafinalproject1.admin.controller;

import com.example.javafinalproject1.admin.service.AdminService;
import com.example.javafinalproject1.model.Route;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class RouteController {

    // Элементы главной таблицы
    @FXML private TableView<Route> table;
    @FXML private TableColumn<Route, Long> colId;
    @FXML private TableColumn<Route, String> colFrom;
    @FXML private TableColumn<Route, String> colTo;
    @FXML private TableColumn<Route, String> colType;

    // Элементы формы добавления (fx:id в FXML должны совпадать!)
    @FXML private TextField txtFrom;
    @FXML private TextField txtTo;
    @FXML private TextField txtType;

    private final AdminService service = new AdminService();

    @FXML
    public void initialize() {
        // Проверка: если мы в окне с таблицей — загружаем данные
        if (table != null) {
            refreshTable();
        }
    }

    private void refreshTable() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getId()).asObject());
        colFrom.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getFromCity()));
        colTo.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getToCity()));
        colType.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTransportType()));

        // Загружаем актуальные данные из БД через сервис
        table.setItems(FXCollections.observableArrayList(service.getRoutes()));
    }

    @FXML
    private void openAddRoute() {
        showForm("AddRoute.fxml", "Add Route");
    }

    @FXML
    private void handleSaveRoute() {
        // 1. Проверка на пустые поля
        if (txtFrom == null || txtFrom.getText().isEmpty() ||
                txtTo == null || txtTo.getText().isEmpty() ||
                txtType == null || txtType.getText().isEmpty()) {
            showAlert("Please fill all fields!");
            return;
        }

        // 2. Создаем объект. Важно: приводим тип к UPPERCASE для ENUM в БД
        Route newRoute = new Route();
        newRoute.setFromCity(txtFrom.getText());
        newRoute.setToCity(txtTo.getText());
        newRoute.setTransportType(txtType.getText().toUpperCase());

        // 3. Сохраняем в базу данных
        service.addRoute(newRoute);

        // 4. Закрываем окно
        Stage stage = (Stage) txtFrom.getScene().getWindow();
        stage.close();

        showAlert("Route added successfully! Please refresh the table.");
    }

    @FXML
    private void deleteRoute() {
        Route r = table.getSelectionModel().getSelectedItem();
        if (r != null) {
            service.deleteRoute(r.getId());
            refreshTable(); // Обновляем список сразу после удаления
        } else {
            showAlert("Please select a route to delete.");
        }
    }

    private void showForm(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafinalproject1/admin/" + fxml));
            // Важно: передаем текущий контроллер или создаем новый корректно
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error loading form: " + fxml);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}