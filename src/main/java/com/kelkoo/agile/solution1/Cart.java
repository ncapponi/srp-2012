package com.kelkoo.agile.solution1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Product> products = new ArrayList<Product>();
	
	private Client client;
	
	private boolean hasPaid = false;

	private final Date creationDate;
	
	public Cart(Client client, Date creationDate) {
		this.client = client;
		this.creationDate = creationDate;
	}

	public void addProduct(Product prod) {
		products.add(prod);
	}
	
	public void removeProduct(Product prod) {
		products.remove(prod);
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public List<String> getProductsNames() {
		List<String> names = new ArrayList<String>();
		for (Product product : products) {
			names.add(product.getName());
		}
		return names;
	}
	
	public float totalPrice() {
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}
	
	public boolean validate() {
		boolean ok = true;
		if (client.isSolvent()) {
			client.pay(totalPrice());
			hasPaid = true;
		}
		else {
			ok = false;
		}
		return ok;
	}
}

