package com.sm.api;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.service.EmployeeBO;
import com.sm.service.EmployeeGetBO;
import com.sm.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

	private EmployeeService employeeService;
	private EmployeeApiMapper employeeApiMapper;

	public EmployeeController(EmployeeApiMapper employeeApiMapper, EmployeeService employeeService) {
		this.employeeApiMapper = employeeApiMapper;
		this.employeeService = employeeService;
	}

	

	@Operation(summary = "Save Employee Data")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Saved successfully", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }) })

	@PostMapping(path = "/save", consumes = "application/json")
	public String saveEmployee(@Valid @RequestBody EmployeeModel employeeModel) {
		// call api mapper
		// call service method save
		EmployeeBO employeeBO = employeeApiMapper.fromEmployeeModelToEmployeeBO(employeeModel);
		int employeeid = employeeService.saveEmployee(employeeBO);
		return "Employee id save successfully " + employeeid;
}
	
	@Operation(summary = "Get Employee Data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get employee Data", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }) })
	
	
	@GetMapping(path="/getEmployeeDetails", produces = "application/json")
	public EmployeeGetModel getEmployeeEntity(@RequestParam int employeeid,@RequestParam String firstName,@RequestParam String lastName) {
	EmployeeGetBO employeeGetBO = employeeService.getEmployee(employeeid, firstName, lastName);
		
EmployeeGetModel employeeGetModel =employeeApiMapper.fromEmployeeGetBOToEmployeeGetModel(employeeGetBO);
		return employeeGetModel;	
	}
}