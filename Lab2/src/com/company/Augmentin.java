package com.company;

public class Augmentin extends Drug{

    private static int number = 0;

    public Augmentin(Float price) {
        super.type = "Antibiotics";
        super.name = "Augmentin";
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
