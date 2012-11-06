package com.kelkoo.agile.live.solution2;

import com.kelkoo.agile.live.solution2.collaborators.Client;
import com.kelkoo.agile.live.solution2.collaborators.Product;

public class Application {

    private CartRepository cartRepository;
	private MailBuilder mailBuilder;
	private Payment payment;
	
	public Application(CartRepository cartRepository,
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
		MailService.sentMailTo(client, mailContent);
	}
	
	public void pay(Client client) throws Exception {
		Cart cart = getCartForClient(client);
		payment.pay(client, cart);
	}
	
	// other services
	// ...

	private static class MailService {
	    
	    static void sentMailTo(Client client, String mailContent) {
	       //Call mail server here
	    }
	}
}
