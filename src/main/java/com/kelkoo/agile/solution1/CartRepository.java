package com.kelkoo.agile.solution1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CartRepository {

    private Database database;    

	public CartRepository(Database database) {
		this.database = database;
	}
	
	public void save(Cart cart) throws IOException {
		serialize(cart);
		// or
        persist(cart);
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
