package com.example.javafinalproject1.model;

import java.time.LocalDateTime;

public class Reservation {
    private long id;
    private long userId;
    private long ticketId;
    private String status;
    private LocalDateTime createdAt;

    public Reservation() {}

    public Reservation(long id, long userId, long ticketId, String status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.ticketId = ticketId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getUserId() { return userId; }
    public void setUserId(long userId) { this.userId = userId; }

    public long getTicketId() { return ticketId; }
    public void setTicketId(long ticketId) { this.ticketId = ticketId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
