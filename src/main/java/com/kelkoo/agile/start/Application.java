package com.kelkoo.agile.start;


import com.kelkoo.agile.start.collaborators.Client;
import com.kelkoo.agile.start.collaborators.Product;


public class Application {

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
		MailService.sentMailTo(client, mailContent);
	}
	
	public void pay(Client client) throws Exception {
		Cart cart = getCartForClient(client);
		cart.validate();
	}
	
	// other services
    // ...
	
    private static class MailService {

        static void sentMailTo(Client client, String mailContent) {
            // Call mail server here
        }
    }
}
