package com.kelkoo.agile.solution3;

import com.kelkoo.agile.solution3.collaborators.Client;

public class CartFactory {

	public SimpleCart getBasicCart(Client client) {
		return null;
	}

	public CartRepository getCartRepository(Client client) {
		return null;
	}

	public MailBuilder getMailBuilder(Client client) {
		return null;
	}

	public Payment getPayment(Client client) {
		return null;
	}


}
