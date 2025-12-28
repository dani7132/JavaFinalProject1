package com.example.javafinalproject1.admin.dao;

import com.example.javafinalproject1.db.DBConnection;
import com.example.javafinalproject1.model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection c = DBConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                Ticket t = new Ticket();
                t.setId(rs.getLong("id"));
                t.setRouteId(rs.getLong("route_id"));
                t.setPrice(rs.getBigDecimal("price"));
                t.setSeatsLeft(rs.getInt("seats_left"));
                tickets.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void deleteTicket(long id) {
        String sql = "DELETE FROM tickets WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Добавьте импорты в TicketDAO по аналогии с RouteDAO
    public void save(Ticket newTicket) {
        // Соответствует структуре из schema.sql
        String sql = "INSERT INTO tickets (route_id, depart_date, depart_time, price, seats_total, seats_left) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, newTicket.getRouteId());

            // Преобразование LocalDate/LocalTime в SQL форматы
            pstmt.setDate(2, java.sql.Date.valueOf(newTicket.getDepartDate()));
            pstmt.setTime(3, java.sql.Time.valueOf(newTicket.getDepartTime()));

            // Использование setBigDecimal для корректной работы с ценой
            pstmt.setBigDecimal(4, newTicket.getPrice());

            pstmt.setInt(5, newTicket.getSeatsTotal());
            pstmt.setInt(6, newTicket.getSeatsLeft());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
