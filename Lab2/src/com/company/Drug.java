package com.company;

public abstract class Drug {
    protected String type;
    protected String name;
    protected Float price;

    public String getType() {
        return type;
    }

    public String getName(){
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public abstract String toString();

    public abstract int getNumber();
}
