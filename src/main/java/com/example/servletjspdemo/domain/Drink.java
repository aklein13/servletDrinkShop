package com.example.servletjspdemo.domain;

public class Drink {
	
	private String name = "";
	private int price = 1;
	
	public Drink() {
		super();
	}
	
	public Drink(String firstName, int yob) {
		super();
		this.name = firstName;
		this.price = yob;
	}

	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int yob) {
		this.price = yob;
	}
}
