package com.company;

public class Fedin extends Drug{
    private static int number = 0;

    public Fedin(Float price) {
        super.type = "Anti-inflammatory";
        super.name = "Fedin";
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
