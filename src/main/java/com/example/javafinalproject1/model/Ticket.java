package com.example.javafinalproject1.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private long id;
    private long routeId;
    private LocalDate departDate;
    private LocalTime departTime;
    private BigDecimal price;
    private int seatsTotal;
    private int seatsLeft;

    public Ticket() {}

    public Ticket(long id, long routeId, LocalDate departDate, LocalTime departTime,
                  BigDecimal price, int seatsTotal, int seatsLeft) {
        this.id = id;
        this.routeId = routeId;
        this.departDate = departDate;
        this.departTime = departTime;
        this.price = price;
        this.seatsTotal = seatsTotal;
        this.seatsLeft = seatsLeft;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getRouteId() { return routeId; }
    public void setRouteId(long routeId) { this.routeId = routeId; }

    public LocalDate getDepartDate() { return departDate; }
    public void setDepartDate(LocalDate departDate) { this.departDate = departDate; }

    public LocalTime getDepartTime() { return departTime; }
    public void setDepartTime(LocalTime departTime) { this.departTime = departTime; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getSeatsTotal() { return seatsTotal; }
    public void setSeatsTotal(int seatsTotal) { this.seatsTotal = seatsTotal; }

    public int getSeatsLeft() { return seatsLeft; }
    public void setSeatsLeft(int seatsLeft) { this.seatsLeft = seatsLeft; }
}
