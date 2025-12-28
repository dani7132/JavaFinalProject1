package com.example.javafinalproject1;



import com.example.javafinalproject1.db.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Соединение с базой успешно!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
