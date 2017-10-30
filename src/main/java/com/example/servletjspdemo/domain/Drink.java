package com.example.servletjspdemo.domain;

public class Drink {

    private String name = "";
    private double price = 1;
    private int amount = 10;

    public Drink() {
        super();
    }

    public int getAmount() {
        return amount;
    }

    public synchronized void buyDrink(int amount) {
        if (this.amount > 0 && this.amount >= amount) {
            this.amount -= amount;
        }
    }

    public Drink(String name, double price, int amount) {
        super();
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
