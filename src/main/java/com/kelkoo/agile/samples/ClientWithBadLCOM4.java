package com.kelkoo.agile.samples;

public class ClientWithBadLCOM4 {
	   
	  public String firstname;
	  public String lastname;
	  public String street;
	  public String city;
	  public String zipCode;
	 
	  public String getFullName() {
	    return firstname + " " + lastname;
	  }
	 
	  public String getFullAddress() {
	    return street + " " + city + " " + zipCode;
	  }
	   
}

