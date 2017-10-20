package com.example.servletjspdemo.domain;

public class Drink {

    private String name = "";
    private int price = 1;
    private int amount = 10;

    public Drink() {
        super();
    }

    public int getAmount() {
        return amount;
    }

    public synchronized boolean buyDrink() {
        if (this.amount > 0) {
            this.amount -= 1;
            return true;
        }
        System.out.println("Dany napój się skończył");
        return false;
    }

    public Drink(String name, int price, int amount) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
