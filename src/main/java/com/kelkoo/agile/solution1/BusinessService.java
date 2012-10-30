package com.kelkoo.agile.solution1;

import com.kelkoo.agile.solution1.collaborators.Client;
import com.kelkoo.agile.solution1.collaborators.Product;


public class BusinessService {

	private CartRepository cartRepository;
	private MailBuilder mailBuilder;
	private Payment payment;
	
	public BusinessService(CartRepository cartRepository,
			MailBuilder mailBuilder, Payment payment) {
		this.cartRepository = cartRepository;
		this.mailBuilder = mailBuilder;
		this.payment = payment;
	}

	public Cart getCartForClient(Client client) throws Exception {
		return cartRepository.find(client);
	}
	
	public void addProduct(Client client, Product product) throws Exception {
		Cart cart = getCartForClient(client);
		cart.addProduct(product);
		cartRepository.save(cart);
	}
	
	public void sendMailTo(Client client) throws Exception {
		Cart cart = getCartForClient(client);
		String mailContent = mailBuilder.getMailContent(cart);
		// mailer.sentMailTo(Client client, content);
	}
	
	public void pay(Client client) throws Exception {
		Cart cart = getCartForClient(client);
		payment.pay(client, cart);
	}
	
	// other services
	// ...
}
