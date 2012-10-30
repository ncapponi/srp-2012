package com.kelkoo.agile.solution3.collaborators;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = -5349600951564538192L;

    public boolean isSolvent() {
		return true;
	}

	public void pay(float totalPrice) {
	   // do something
	}
	
	public int getId() {
	        return 0;
    }

}
