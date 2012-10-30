package com.kelkoo.agile.solution3;

import java.util.List;

import com.kelkoo.agile.solution3.collaborators.Product;

interface SimpleCart {

	void addProduct(Product prod);

	void removeProduct(Product prod);

	List<Product> getProducts();

	List<String> getProductsNames();

	float getTotalPrice();

}