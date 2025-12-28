package com.example.javafinalproject1.admin.controller;

import com.example.javafinalproject1.admin.service.AdminService;
import com.example.javafinalproject1.model.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class UserController {

    @FXML private TableView<User> table;
    @FXML private TableColumn<User, Long> colId;
    @FXML private TableColumn<User, String> colName;
    @FXML private TableColumn<User, String> colEmail;
    @FXML private TableColumn<User, String> colRole;

    // Поля для AddUser.fxml / EditUser.fxml
    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtRole;

    private final AdminService service = new AdminService();

    @FXML
    public void initialize() {
        if (table != null) {
            colId.setCellValueFactory(c -> new javafx.beans.property.SimpleLongProperty(c.getValue().getId()).asObject());
            colName.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getFullName()));
            colEmail.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEmail()));
            colRole.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getRole()));
            loadUsers();
        }
    }

    private void loadUsers() {
        table.setItems(FXCollections.observableArrayList(service.getUsers()));
    }

    @FXML private void openAddUser() { showForm("AddUser.fxml", "Add New User"); }

    @FXML private void openEditUser() {
        if (table.getSelectionModel().getSelectedItem() != null) {
            showForm("EditUser.fxml", "Edit User");
        }
    }

    @FXML
    private void deleteUser() {
        User u = table.getSelectionModel().getSelectedItem();
        if (u != null) {
            service.deleteUser(u.getId());
            loadUsers();
        }
    }

    private void showForm(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafinalproject1/admin/" + fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) { e.printStackTrace(); }
    }
}