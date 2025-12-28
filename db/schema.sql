-- Ticket Booking System (MySQL)
-- Schema v1

DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS routes;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('USER','ADMIN') NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE routes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_city VARCHAR(80) NOT NULL,
    to_city VARCHAR(80) NOT NULL,
    transport_type ENUM('BUS','TRAIN','AIRPLANE') NOT NULL
);

CREATE TABLE tickets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    route_id BIGINT NOT NULL,
    depart_date DATE NOT NULL,
    depart_time TIME NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    seats_total INT NOT NULL,
    seats_left INT NOT NULL,
    CONSTRAINT fk_tickets_route FOREIGN KEY (route_id) REFERENCES routes(id)
);

CREATE TABLE reservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    ticket_id BIGINT NOT NULL,
    status ENUM('BOOKED','CANCELLED') NOT NULL DEFAULT 'BOOKED',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_res_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_res_ticket FOREIGN KEY (ticket_id) REFERENCES tickets(id),
    CONSTRAINT uq_user_ticket UNIQUE (user_id, ticket_id)
);
