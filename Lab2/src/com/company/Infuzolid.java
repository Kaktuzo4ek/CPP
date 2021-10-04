package com.company;

public class Infuzolid extends Drug{
    private static int number = 0;

    public Infuzolid(Float price) {
        super.type = "Antibiotics";
        super.name = "Infuzolid";
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
