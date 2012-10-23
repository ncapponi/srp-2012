package com.kelkoo.agile.solution1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartRepository {

    private Database database;    

	public CartRepository(Database database) {
		this.database = database;
	}
	
	public void save(Cart cart) throws IOException {
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("cart.ser"));
		stream.writeObject(cart);
		stream.close();

        // or
        database.startTransaction();
        database.doUpdate(getSqlUpdateRequest(cart));
        database.commit();
	}
	
	public String getSqlUpdateRequest(cart) {
		return format("insert into carts date=? clientId=? ....", cart.getDate(), cart.getClient().getId());
	}
	
}
