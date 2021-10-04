package com.company;

public class Sargin extends Drug{
    private static int number;

    public Sargin(Float price) {
        super.type = "Antibiotics";
        super.name = "Sargin";
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
