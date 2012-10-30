package com.kelkoo.agile.solution3;

import com.kelkoo.agile.solution3.collaborators.Client;

interface CartRepository {

	void save() throws Exception;
	
	SimpleCart find(Client client) throws Exception;

	String getSqlInsertRequest();

}