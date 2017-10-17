package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Drink;

public class StorageService {
	
	private List<Drink> db = new ArrayList<Drink>();
	
	public void add(Drink person){
		Drink newPerson = new Drink(person.getName(), person.getPrice());
		db.add(newPerson);
	}
	
	public List<Drink> getAllPersons(){
		return db;
	}

}
