package com.example.javafinalproject1.admin.service;

import com.example.javafinalproject1.admin.dao.*;
import com.example.javafinalproject1.model.*;

import java.util.List;

public class AdminService {

    private final UserDAO userDAO = new UserDAO();
    private final RouteDAO routeDAO = new RouteDAO();
    private final TicketDAO ticketDAO = new TicketDAO();

    // --- Управление ПОЛЬЗОВАТЕЛЯМИ ---
    public List<User> getUsers() {
        return userDAO.getAllUsers();
    }

    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    // --- Управление МАРШРУТАМИ ---
    public List<Route> getRoutes() {
        return routeDAO.getAllRoutes();
    }

    public void addRoute(Route newRoute) {
        // Здесь мы вызываем метод save в DAO для записи в таблицу routes
        routeDAO.save(newRoute);
    }

    public void deleteRoute(long id) {
        routeDAO.deleteRoute(id);
    }

    // --- Управление БИЛЕТАМИ ---
    public List<Ticket> getTickets() {
        return ticketDAO.getAllTickets();
    }

    public void addTicket(Ticket newTicket) {
        // Добавление билета в таблицу tickets
        ticketDAO.save(newTicket);
    }

    public void deleteTicket(long id) {
        ticketDAO.deleteTicket(id);
    }
    public void addUser(User user) {
        userDAO.save(user);
    }

}