package com.kelkoo.agile.solution4;


import com.kelkoo.agile.start.collaborators.Client;
import com.kelkoo.agile.start.collaborators.Product;


public class BusinessService {

	public Cart getCartForClient(Client client) throws Exception {
		Cart cart = Cart.find(client);
		return cart;
	}
	
	public void addProduct(Client client, Product product) throws Exception {
		Cart cart = getCartForClient(client);
		cart.addProduct(product);
		cart.save();
	}
	
	public void sendMailTo(Client client) throws Exception {
		Cart cart = getCartForClient(client);
		String mailContent = cart.computeMailContent();
		// mailer.sentMailTo(Client client, content);
	}
	
	public void pay(Client client) throws Exception {
		Cart cart = getCartForClient(client);
		cart.validate();
	}
	
	// other services
    // ...
}
