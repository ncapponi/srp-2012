package com.kelkoo.agile.step1;

import java.util.Date;
import java.util.List;

import com.kelkoo.agile.step1.collaborators.Client;
import com.kelkoo.agile.step1.collaborators.Product;
import com.kelkoo.agile.step1.collaborators.Status;

public class CartReference {

	private List<Product> products;

	private Client client;

	private Date date;

	private Status status;

	
	public List<Product> getProducts() {
		return products;
	}

	public Client getClient() {
		return client;
	}

	public Date getDate() {
		return date;
	}

	public Status getStatus() {
		return status;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public float computeTotalPrice() {
		float total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}

	public String computeSqlInsertRequest() {
		return "insert into carts date=? clientId=? ....";
	}

	public String computeMailContent() {
		String content = "Bonjour,\nVotre panier composé le " + date
				+ " comporte les éléments suivants :\n";
		for (Product product : products) {
			content += "- " + product.getName() + " au prix de "
					+ product.getPrice() + "\n";
		}
		return content;
	}
}
