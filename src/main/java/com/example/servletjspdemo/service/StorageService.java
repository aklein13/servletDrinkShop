package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Drink;

public class StorageService {

    private List<Drink> db = new ArrayList<Drink>();

    public void add(Drink drink) {
        Drink newDrink = new Drink(drink.getName(), drink.getPrice(), drink.getAmount());
        db.add(newDrink);
    }

    public List<Drink> getAllDrinks() {
        return db;
    }

    public int drinksCount() {
        return db.size();
    }

    public void generateDrinks() {
        if (db.size() == 0) {
            Drink newDrink1 = new Drink("cola", 5, 6);
            Drink newDrink2 = new Drink("fanta", 15, 15);
            Drink newDrink3 = new Drink("sprite", 10, 2);
            db.add(newDrink1);
            db.add(newDrink2);
            db.add(newDrink3);
        }
    }

}
