package com.kelkoo.agile.samples;

public class ClientWithGoodLCOM4 {
	   
	  public String firstname;
	  public String lastname;
	  public Address address; 
	  
	  public String getFullName() {
	    return firstname + " " + lastname;
	  }
	 
	  public String getFullAddress() {
	    return address.getFullAddress();
	  }
	  
	  static public class Address {
		   
		  public String street;
		  public String city;
		  public String zipCode;
		 
		  public String getFullAddress() {
		    return street + " " + city + " " + zipCode;
		  }
	  }
	   
}

