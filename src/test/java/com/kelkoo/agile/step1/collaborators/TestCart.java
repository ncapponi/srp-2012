package com.kelkoo.agile.step1.collaborators;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Test;

public class TestCart {

	@Test
	public void composeMail() throws Exception {
		Client client = mock(Client.class);
		Date creationDate = mock(Date.class);
		when(creationDate.toString()).thenReturn("20121008");
		Cart cart = new Cart(client, creationDate);
		cart.addProduct(new Product("monProduit", 2.0f));

		String expectedContent = "Bonjour,\nVotre panier composé le 20121008 comporte les éléments suivants :\n- monProduit au prix de 2.0\n";
		assertThat(cart.computeMailContent(), Is.is(expectedContent));
	}

	private Cart newCart(Product... prods) {
		Cart cart = new Cart(mock(Client.class), mock(Date.class));
		for (Product product : prods) {
			cart.addProduct(product);
		}
		return cart;
	}

	@Test
	public void testAddProduct() {
		Product product = mock(Product.class);
		Cart cart = newCart(product); 
		assertThat(cart.getProducts().size(), is(1));
		assertThat(cart.getProducts().get(0), is(product));
	}

	@Test
	public void testRemoveProduct() {
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Product product3 = mock(Product.class);
		Cart cart = newCart(product1, product2, product3); 
		cart.removeProduct(product2);
		assertThat(cart.getProducts().size(), is(2));
		assertThat(cart.getProducts(), is(asList(product1,product3)));
	}

}
