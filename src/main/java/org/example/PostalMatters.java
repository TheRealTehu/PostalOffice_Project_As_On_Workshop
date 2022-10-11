package org.example;

import java.time.LocalDate;

public abstract class PostalMatters {
    private String address;
    private String name;
    private LocalDate date;
    private double price;

    public PostalMatters(String address, String name, LocalDate date) {
        this.address = address;
        this.name = name;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
