package com.kelkoo.agile.step1.start;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Test;

import com.kelkoo.agile.start.Cart;
import com.kelkoo.agile.start.Client;
import com.kelkoo.agile.start.Product;

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
        assertThat(cart.totalPrice(), is(3.0f));
    }

    @Test
    public void validateIfClientIsSolvent() {
        Client client = mock(Client.class);
        when(client.isSolvent()).thenReturn(true);
        Cart cart = new Cart(client, mock(Date.class));
        assertThat(cart.validate(), is(true));
    }

    @Test
    public void validateIfClientIsNotSolvent() {
        Client client = mock(Client.class);
        when(client.isSolvent()).thenReturn(false);
        Cart cart = new Cart(client, mock(Date.class));
        assertThat(cart.validate(), is(false));
    }

    @Test
    public void save() throws IOException, ClassNotFoundException {
        Cart cart = new Cart(new Client(),new Date());
        Product product = new Product("monProduit", 1.0f);
        cart.addProduct(product);
        cart.save();
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("cart.ser"));
        Cart savedCart = (Cart)stream.readObject();
        stream.close();
        assertThat(savedCart.getProducts().size(), is(1));
        assertThat(savedCart.getProducts().get(0), is(product));
    }
    
    @AfterClass
    public static void tearDown() {
        File file = new File("cart.ser");
        if(file.exists()){
            file.delete();
        }
    }
    
}
