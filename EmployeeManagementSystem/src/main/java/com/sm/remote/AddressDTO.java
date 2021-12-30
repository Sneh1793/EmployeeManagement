package com.sm.remote;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sm.remote.AddressDetailDTO ;
import lombok.Data;

@Data
public class AddressDTO implements Serializable {
	

	private static final long serialVersionUID = 7478353308944659254L;
		@JsonProperty("Message") 
	    public String message;
	    @JsonProperty("Status") 
	    public String status;
	    @JsonProperty("PostOffice") 
	    public List<AddressDetailDTO> addressDetailDTO;
	
}
