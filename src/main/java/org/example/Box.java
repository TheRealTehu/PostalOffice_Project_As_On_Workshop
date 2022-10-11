package org.example;

import java.time.LocalDate;

public class Box extends PostalMatters{
    private BoxType type;
    private int weight;

    public Box(String address, String name, LocalDate date, BoxType type, int weight) {
        super(address, name, date);
        this.type = type;
        this.weight = weight;
        setPrice(calculatePrice());
    }

    public BoxType getType() {
        return type;
    }

    private double calculatePrice(){
        return type.getBasePrice() + (type.getMultiplier() * weight);
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return type + " box from: " + getName()
                + " to: " + getAddress()
                + " on: " + getDate()
                + " price: " + getPrice();
    }
}
