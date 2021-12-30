package com.sm.api;

import java.io.Serializable;

import lombok.Data;
@Data
public class AddressModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5377902224430375729L;

	 public String name;
	    
	    public String description;
	    
	    public String branchType;
	 
	    public String deliveryStatus;
	   
	    public String taluk;
	  
	    public String circle;
	 
	    public String district;
	   
	    public String division;
	  
	    public String region;
	  
	    public String state;
	 
	    public String country;
	
	
}
