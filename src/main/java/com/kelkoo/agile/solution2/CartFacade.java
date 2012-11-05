package com.kelkoo.agile.solution2;

import java.util.List;

import com.kelkoo.agile.solution2.collaborators.Client;
import com.kelkoo.agile.solution2.collaborators.Product;

public class CartFacade {

    private Cart cart;
    private CartRepository repository;
    private MailBuilder mailBuilder;
    private Payment payment;

    public CartFacade(Cart cart, CartRepository repository, MailBuilder mailBuilder, Payment payment) {
        this.cart = cart;
        this.repository = repository;
        this.mailBuilder = mailBuilder;
        this.payment = payment;
    }

    public void addProduct(Product product) {
        cart.addProduct(product);
    }

    public void removeProduct(Product product) {
        cart.removeProduct(product);
    }

    public List<Product> getProducts() {
        return cart.getProducts();
    }

    public List<String> getProductsNames() {
        return cart.getProductsNames();
    }

    public float getTotalPrice() {
        return cart.getTotalPrice();
    }

    public boolean validate() {
        return payment.pay(cart.getClient(), cart);
    }

    public void save() throws Exception {
        repository.save(cart);
    }

    public static CartFacade find(Client client, CartRepository repository) throws Exception {
        Cart cart = repository.find(client);
        return new CartFacade(cart, repository, new MailBuilder(), new Payment());
    }

    public String computeMailContent() {
        return mailBuilder.getMailContent(cart);
    }
}
