package com.example.javafinalproject1.admin.dao;

import com.example.javafinalproject1.db.DBConnection;
import com.example.javafinalproject1.model.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.javafinalproject1.db.DBConnection;
import com.example.javafinalproject1.model.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO {

    public void save(Route route) {
        // SQL запрос соответствует вашей схеме: таблицы routes(from_city, to_city, transport_type)
        String sql = "INSERT INTO routes (from_city, to_city, transport_type) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, route.getFromCity());
            pstmt.setString(2, route.getToCity());

            // ВАЖНО: Мы переводим строку в верхний регистр, так как в SQL ENUM ('BUS','TRAIN','AIRPLANE')
            pstmt.setString(3, route.getTransportType().toUpperCase());

            pstmt.executeUpdate();
            System.out.println("Route saved successfully!");

        } catch (SQLException e) {
            System.err.println("Error saving route: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT * FROM routes"; // Соответствует таблице из schema.sql

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getLong("id"));
                route.setFromCity(rs.getString("from_city"));
                route.setToCity(rs.getString("to_city"));
                route.setTransportType(rs.getString("transport_type"));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }
    public void deleteRoute(long id) {
        // SQL запрос для удаления записи из таблицы routes
        String sql = "DELETE FROM routes WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Route deleted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting route: " + e.getMessage());
            e.printStackTrace();
        }
    }
}