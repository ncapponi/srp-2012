package com.kelkoo.agile.solution3;


import com.kelkoo.agile.solution3.collaborators.Client;
import com.kelkoo.agile.solution3.collaborators.Product;


public class Application {
	
	CartFactory factory;
	
	public SimpleCart getCartForClient(Client client) throws Exception {
		SimpleCart cart = factory.getBasicCart(client);
		return cart;
	}
	
	public void addProduct(Client client, Product product) throws Exception {
		SimpleCart cart = getCartForClient(client);
		cart.addProduct(product);
		CartRepository cartRepository = factory.getCartRepository(client);
		cartRepository.save();
	}
	
	public void sendMailTo(Client client) throws Exception {
		MailBuilder mailBuilder = factory.getMailBuilder(client); 
		String mailContent = mailBuilder.computeMailContent();
		// mailer.sentMailTo(Client client, content);
	}
	
	public void pay(Client client) throws Exception {
		Payment payment = factory.getPayment(client);
		payment.validate();
	}
	
	// other services
    // ...
}
