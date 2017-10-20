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

}
