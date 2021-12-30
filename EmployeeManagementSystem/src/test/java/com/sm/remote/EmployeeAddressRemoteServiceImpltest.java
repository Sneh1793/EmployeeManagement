package com.sm.remote;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.github.tomakehurst.wiremock.WireMockServer;

import wiremock.com.fasterxml.jackson.core.JsonProcessingException;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

//@SpringBootTest
@AutoConfigureWireMock(port=0)
@ExtendWith(SpringExtension.class)
public class EmployeeAddressRemoteServiceImpltest {

	@Autowired private WireMockServer wireMockServer;
	private EmployeeAddressRemoteService employeeAddressRemoteService;
	
	
	/*@Value("${wiremock.server.port}")
	private String portNumber; */
	
@BeforeEach
void setup() {
	RestTemplate restTemplate = new RestTemplate();
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(wireMockServer.baseUrl()));
  employeeAddressRemoteService  = new EmployeeAddressRemoteServiceImpl(restTemplate);
}

		 
 @Test
void getEmployee() throws JsonProcessingException {
//	AddressDTO addressDTO = new AddressDTO(); 
//	AddressDetailDTO addressDetailDTO = new AddressDetailDTO();
//		
//addressDetailDTO.setName("Indira Nagar (Lucknow)");
//addressDetailDTO.setBranchType("Sub Post Office");
//addressDetailDTO.setCircle("NA");
//addressDetailDTO.setDistrict("Lucknow");
//addressDetailDTO.setDescription("Lucknow");
//addressDetailDTO.setRegion("Lucknow  HQ");
//addressDetailDTO.setState("Uttar Pradesh");
//addressDetailDTO.setTaluk("NA");
//addressDetailDTO.setCountry("India");
//addressDetailDTO.setDeliveryStatus("Delivery");
//addressDetailDTO.setDivision("Lucknow");
//
//List<AddressDetailDTO> addressDetails = new ArrayList<>();
//addressDetails.add(addressDetailDTO);
//
//addressDTO.setAddressDetailDTO(addressDetails);	

	stubFor(get(urlMatching("/api/pincode/226016")).willReturn(aResponse()
			.withHeader("Content-Type", "application/json").withBodyFile("postOffice.json")));

	List<AddressDetailDTO> addressDetailDTOs= employeeAddressRemoteService.getEmployeeAddress(226016);
  assertEquals("India",addressDetailDTOs.get(0).country);
  
 }

}
