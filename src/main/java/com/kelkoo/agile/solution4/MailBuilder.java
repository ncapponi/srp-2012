package com.kelkoo.agile.solution4;

import java.util.Date;

public class MailBuilder implements CartVisitor {

	private StringBuilder cartContent;
	private StringBuilder productsContent;
	
	public String getMailContent(Cart cart) {
		cart.accept(this);
		return cartContent.append(productsContent).toString();
	}

	public void beforeVisit() {
	    cartContent = new StringBuilder();
		productsContent = new StringBuilder();
	}
	
	public void afterVisit() {
		// nothing to do
	}
	
	public void visitCart(Date creationDate, String clientId) {
		buildMailHeader(creationDate);
	}

	public void visitProduct(String name, float price) {
		addProductToMail(name, price);
	}

	private void buildMailHeader(Date creationDate) {
		cartContent.append("Bonjour,\n")
		       .append("Votre panier composé le ")
			   .append(creationDate)
			   .append(" comporte les éléments suivants :\n");
	}

	private void addProductToMail(String name, float price) {
		productsContent.append("- ")
			.append(name)
			.append(" au prix de ")
			.append(price).append("\n");
	}

}
