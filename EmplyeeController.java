package com.employee.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crudoperation.model.EmployeeDetails;
import com.employee.crudoperation.model.EmployeeMaster;
import com.employee.crudoperation.service.EmployeeService;

@RestController
public class EmplyeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee/{empid}")
	public ResponseEntity<EmployeeMaster>  getEmploye(@PathVariable("empid") int empId) throws Exception{
		EmployeeMaster empMaster= employeeService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeMaster>(empMaster, HttpStatus.OK);
	}
	
	@PostMapping("/employee")  
	public ResponseEntity<EmployeeMaster> saveEmploye(@RequestBody EmployeeMaster employee)   
	{  
	 EmployeeMaster emp=employeeService.saveEmployee(employee);  
	 return new ResponseEntity<EmployeeMaster>(emp, HttpStatus.OK);
	} 
	
	@PutMapping("/employee")
	public ResponseEntity<EmployeeMaster> updateEmploye(@RequestBody EmployeeMaster employee)
	{
		EmployeeMaster emp=employeeService.updateEmployee(employee);
		return new ResponseEntity<EmployeeMaster>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("employee/{empid}")
	public ResponseEntity<String> deleteEmploye(@PathVariable("empid") String empid) throws Exception
	{
	employeeService.deleteEmploye(empid);
	return new ResponseEntity<String>("Employe Deleted With ID"+empid, HttpStatus.OK);
	}
	
	@GetMapping("/employee/all")
	public ResponseEntity<List<EmployeeMaster>> getAllEmploye(){
		List<EmployeeMaster> emplist= employeeService.getAllEmploye();
		return new ResponseEntity<List<EmployeeMaster>>(emplist, HttpStatus.OK);
	}
	
	@GetMapping("/details/{empid}")
	public EmployeeDetails getEmployeDetail(@PathVariable("empid") String empid){
		return employeeService.getEmploye(empid);
	}
}
