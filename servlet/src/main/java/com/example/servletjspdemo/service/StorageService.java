package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Drink;

public class StorageService {

    private List<Drink> db = new ArrayList<Drink>();

    public void add(Drink drink) {
        String drinkName = drink.getName();
        for (Drink drinkCheck : db) {
            if (drinkCheck.getName().equals(drinkName)) {
                System.out.println("There already is a drink: " + drinkName);
                return;
            }
        }
        Drink newDrink = new Drink(drinkName, drink.getPrice(), drink.getAmount());
        db.add(newDrink);
    }

    public List<Drink> getAllDrinks() {
        return db;
    }

    // names are unique
    public double buyDrink(String name, int amount) {
        for (Drink drink : db) {
            if (drink.getName().equals(name)) {
                if(drink.getAmount() == 0 || drink.getAmount() < amount){
                    return 0.0;
                }
                drink.buyDrink(amount);
                System.out.println("Bought " + name);
                return drink.getPrice();
            }
        }
        return 0.0;
    }

    public void generateDrinks() {
        if (db.size() == 0) {
            Drink newDrink1 = new Drink("cola", 5.5, 6);
            Drink newDrink2 = new Drink("fanta", 15, 15);
            Drink newDrink3 = new Drink("sprite", 10, 2);
            db.add(newDrink1);
            db.add(newDrink2);
            db.add(newDrink3);
        }
    }

}
