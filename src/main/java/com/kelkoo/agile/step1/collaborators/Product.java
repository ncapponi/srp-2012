package com.kelkoo.agile.step1.collaborators;

public class Product {

	private final String name;
	private final float price;

	public Product(String name, float prix) {
		this.name = name;
		this.price = prix;
	}

	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
