package com.example.javafinalproject1.model;

public class Route {
    private long id;
    private String fromCity;
    private String toCity;
    private String transportType; // BUS / TRAIN / AIRPLANE

    public Route() {}

    public Route(long id, String fromCity, String toCity, String transportType) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.transportType = transportType;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFromCity() { return fromCity; }
    public void setFromCity(String fromCity) { this.fromCity = fromCity; }

    public String getToCity() { return toCity; }
    public void setToCity(String toCity) { this.toCity = toCity; }

    public String getTransportType() { return transportType; }
    public void setTransportType(String transportType) { this.transportType = transportType; }
}
