package com.kelkoo.agile.solution2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kelkoo.agile.solution2.collaborators.Client;
import com.kelkoo.agile.solution2.collaborators.Database;

public class CartRepository {

    private Database database;    

	public CartRepository(Database database) {
		this.database = database;
	}
	
	public void save(Cart cart) throws IOException {
		serialize(cart);
		// or 
	    // persist(cart);
	}
	
	public Cart find(Client client) throws Exception {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream("cart" + client.getId() + ".ser"));
		Cart cart = (Cart) stream.readObject();
		stream.close();
		return cart;
	}

    private void serialize(Cart cart) throws IOException, FileNotFoundException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("cart.ser"));
		stream.writeObject(cart);
		stream.close();
    }

    private void persist(Cart cart) {
        database.startTransaction();
        database.doUpdate(getSqlUpdateRequest(cart));
        database.commit();
    }
	
	private String getSqlUpdateRequest(Cart cart) {
		return String.format("insert into carts (%s, %s)", cart.getCreationDate(), cart.getClientId());
	}
	
}
