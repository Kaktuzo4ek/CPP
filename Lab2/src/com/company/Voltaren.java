package com.company;

public class Voltaren extends Drug{

    private static int number = 0;

    public Voltaren(Float price) {
        super.type = "Anti-inflammatory";
        super.name = "Voltaren";
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
