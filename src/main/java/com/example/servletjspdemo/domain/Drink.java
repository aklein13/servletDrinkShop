package com.example.servletjspdemo.domain;

public class Drink {
	
	private String name = "";
	private int price = 1;
	
	public Drink() {
		super();
	}
	
	public Drink(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
