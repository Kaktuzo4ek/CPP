package com.company;

public class Gofen extends Drug{
    private static int number = 0;

    public Gofen(Float price) {
        super.type = "Antipyretic";
        super.name = "Gofen";
        super.price = price;
        number++;
    }


    @Override
    public String toString() {
        return "Drug{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int getNumber() {
        return number;
    }
}
