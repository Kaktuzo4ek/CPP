package com.company;

public class Paracetamol extends Drug{
    private static int number = 0;

    public Paracetamol(Float price) {
        super.type = "Antipyretic";
        super.name = "Paracetamol";
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
