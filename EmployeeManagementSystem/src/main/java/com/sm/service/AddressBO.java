package com.sm.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddressBO {
	
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
