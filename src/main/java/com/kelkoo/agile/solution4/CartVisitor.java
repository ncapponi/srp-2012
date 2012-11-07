package com.kelkoo.agile.solution4;

import java.util.Date;

public interface CartVisitor {

	void visitCart(Date creationDate, String clientId);

	void visitProduct(String name, float price);
	
	
	
	
	// additional methods to be able to detect start and end of visit

	void afterVisit();

	void beforeVisit();

}

