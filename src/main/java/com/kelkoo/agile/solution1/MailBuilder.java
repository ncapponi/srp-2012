package com.kelkoo.agile.solution1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailBuilder {

 
	public MailBuilder() {
	}
	
	public String getMailContent(Cart cart) {
		 StringBuilder content = new StringBuilder("Bonjour,\n");
         content.append("Votre panier composé le ").
                 append(cart.getCreationDate()).
		         append(" comporte les éléments suivants :\n");
		 for (Product product : cart.getProducts()) {
		  content.append("- ").append(product.getName()).
            append(" au prix de ").
            append(product.getPrice()).
            append("\n");
		 }
		 return content.toString();
	}
	
}
