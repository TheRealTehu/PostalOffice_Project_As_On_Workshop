package org.example;

import java.time.LocalDate;

public class Letter extends PostalMatters{
    private final double PRICE_OF_LETTER = 1.99;

    public Letter(String address, String name, LocalDate date) {
        super(address, name, date);
        setPrice(PRICE_OF_LETTER);
    }

    @Override
    public String toString() {
        return "Letter from: " + getName()
                + " to: " + getAddress()
                + " on: " + getDate();
    }
}
