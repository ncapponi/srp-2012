package com.kelkoo.agile.solution2;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import com.kelkoo.agile.solution2.Cart;
import com.kelkoo.agile.solution2.collaborators.Client;
import com.kelkoo.agile.solution2.collaborators.Product;

public class TestCart {

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
        assertThat(cart.getProducts(), is(asList(product1, product3)));
    }

    @Test
    public void getProducts() {
        Product product = mock(Product.class);
        Cart cart = newCart(product);
        assertThat(cart.getProducts(), is(asList(product)));
    }

    @Test
    public void getProductsNames() {
        Product product1 = mock(Product.class);
        when(product1.getName()).thenReturn("monProduit1");
        Product product2 = mock(Product.class);
        when(product2.getName()).thenReturn("monProduit2");
        Cart cart = newCart(product1, product2);
        assertThat(cart.getProductsNames(), is(asList("monProduit1", "monProduit2")));
    }

    @Test
    public void totalPrice() {
        Product product1 = mock(Product.class);
        when(product1.getPrice()).thenReturn(2.0f);
        Product product2 = mock(Product.class);
        when(product2.getPrice()).thenReturn(1.0f);
        Cart cart = newCart(product1, product2);
        assertThat(cart.getTotalPrice(), is(3.0f));
    }
}
