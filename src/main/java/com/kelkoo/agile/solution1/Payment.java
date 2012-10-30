package com.kelkoo.agile.solution1;

import com.kelkoo.agile.solution1.collaborators.Client;

public class Payment {

	public boolean pay(Client client, Cart cart) {
		boolean paid = false;
		if (client.isSolvent() && !cart.isPaid()) {
			client.pay(cart.getTotalPrice());
			cart.clientHasPaid();
			paid = true;
		} 
		return paid;
	}
}
