package com.sm.remote;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddressDetailDTO implements Serializable {
	
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 6862235027874670150L;
		@JsonProperty("Name") 
	    public String name;
	    @JsonProperty("Description") 
	    public String description;
	    @JsonProperty("BranchType") 
	    public String branchType;
	    @JsonProperty("DeliveryStatus") 
	    public String deliveryStatus;
	    @JsonProperty("Taluk") 
	    public String taluk;
	    @JsonProperty("Circle") 
	    public String circle;
	    @JsonProperty("District") 
	    public String district;
	    @JsonProperty("Division") 
	    public String division;
	    @JsonProperty("Region") 
	    public String region;
	    @JsonProperty("State") 
	    public String state;
	    @JsonProperty("Country") 
	    public String country;
	}

	



