package com.sm.remote;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
public class EmployeeAddressRemoteServiceImpl implements EmployeeAddressRemoteService {
	public static final String URL = "/api/pincode/";
	
	private RestTemplate restTemplate;

	public EmployeeAddressRemoteServiceImpl(@Qualifier("remoteRestTemplate") RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;
	}

	@Override
	public   List<AddressDetailDTO> getEmployeeAddress(int pinCode) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);
		 ResponseEntity<AddressDTO> result= restTemplate.exchange(URL+pinCode, HttpMethod.GET,request ,AddressDTO.class );
			 
		return result.getBody().getAddressDetailDTO();
	}
	
	
	
}
