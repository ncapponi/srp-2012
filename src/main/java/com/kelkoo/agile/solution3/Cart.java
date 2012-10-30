package com.kelkoo.agile.solution3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kelkoo.agile.solution3.collaborators.Client;
import com.kelkoo.agile.solution3.collaborators.Product;

public class Cart implements Serializable, SimpleCart, MailBuilder, CartRepository, Payment {

	private static final long serialVersionUID = 1L;

	private List<Product> products = new ArrayList<Product>();
	
	private Client client;
	
	private boolean hasPaid = false;

	private final Date creationDate;
	
	public Cart(Client client, Date creationDate) {
		this.client = client;
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.BasicCart#addProduct(com.kelkoo.agile.solution3.collaborators.Product)
	 */
	public void addProduct(Product prod) {
		products.add(prod);
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.BasicCart#removeProduct(com.kelkoo.agile.solution3.collaborators.Product)
	 */
	public void removeProduct(Product prod) {
		products.remove(prod);
	}

	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.BasicCart#getProducts()
	 */
	public List<Product> getProducts() {
		return products;
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.BasicCart#getProductsNames()
	 */
	public List<String> getProductsNames() {
		List<String> names = new ArrayList<String>();
		for (Product product : products) {
			names.add(product.getName());
		}
		return names;
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.BasicCart#getTotalPrice()
	 */
	public float getTotalPrice() {
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.Payment#validate()
	 */
	public boolean validate() {
		boolean ok = true;
		if (client.isSolvent() && !hasPaid) {
			client.pay(getTotalPrice());
			hasPaid = true;
		}
		else {
			ok = false;
		}
		return ok;
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.CartRepository#save()
	 */
	public void save() throws IOException {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("cart.ser"));
		stream.writeObject(this);
		stream.close();
	}
	
	public Cart find(Client client) throws Exception {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream("cart" + client.getId() + ".ser"));
		Cart cart = (Cart) stream.readObject();
		stream.close();
		return cart;
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.CartRepository#getSqlInsertRequest()
	 */
	public String getSqlInsertRequest() {
		return "insert into carts date=? clientId=? ....";
	}
	
	/* (non-Javadoc)
	 * @see com.kelkoo.agile.solution3.MailBuilder#computeMailContent()
	 */
	public String computeMailContent() {
		 String content = "Bonjour,\nVotre panier composé le " + creationDate
		   + " comporte les éléments suivants :\n";
		 for (Product product : products) {
		  content += "- " + product.getName() + " au prix de "
		    + product.getPrice() + "\n";
		 }
		 return content;
		}
	
}
