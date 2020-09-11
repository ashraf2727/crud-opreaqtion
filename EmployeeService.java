package com.employee.crudoperation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.crudoperation.model.EmployeContact;
import com.employee.crudoperation.model.EmployeeDetails;
import com.employee.crudoperation.model.EmployeeMaster;
import com.employee.crudoperation.repository.EmployeeContactRepo;
import com.employee.crudoperation.repository.EmployeDetailRepo;
import com.employee.crudoperation.repository.EmployeMasterRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeMasterRepo employeMasterRepository;

	@Autowired
	EmployeeContactRepo employeeContactRepository;
	
	@Autowired
	EmployeDetailRepo employeDetailRepository;

	public EmployeeMaster getEmployeeById(int empid) throws Exception {
		
		EmployeeMaster employeeMaster=null;
		try {
			 employeeMaster = employeMasterRepository.findById(empid).get();
		} catch (Exception e) {
			 throw new Exception("Object does not exist with id =  "+ empid);
		}

		List<EmployeContact> employeContactList = employeeMaster.getEmpContacts();

		List<EmployeContact> newEmployeContactList = new ArrayList<EmployeContact>();

		for (EmployeContact employeContact : employeContactList) {
			Integer ecid = Integer.valueOf(employeContact.getEcid());
			EmployeContact contact = employeeContactRepository.findById(ecid).get();
			if (contact != null) {
				newEmployeContactList.add(contact);
			}
		}
		employeeMaster.setEmpContacts(newEmployeContactList);
		return employeeMaster;
	}

	public EmployeeMaster saveEmployee(EmployeeMaster empMaster) {
		List<EmployeContact> empContactSet = empMaster.getEmpContacts();
		EmployeeDetails employeeDetails=empMaster.getEmpDetails();
		employeDetailRepository.save(employeeDetails);
		employeeContactRepository.saveAll(empContactSet);
		EmployeeMaster emp=employeMasterRepository.save(empMaster);
		return emp;
	}

	public void deleteEmploye(String empid) throws Exception {
		try {
			employeMasterRepository.deleteById(Integer.valueOf(empid));
		} catch (Exception e) {
			throw new Exception("No Object Exist with Id = "+ empid);
		}
	}
	
	public EmployeeMaster updateEmployee(EmployeeMaster empMaster) {
		List<EmployeContact> empContactList = empMaster.getEmpContacts();
		List<EmployeContact> newEmpContactList = employeeContactRepository.saveAll(empContactList);
		
		EmployeeMaster emp=employeMasterRepository.save(empMaster);
		
		EmployeeDetails empDetail=empMaster.getEmpDetails();
		EmployeeDetails newEmployeeDetail= employeDetailRepository.save(empDetail);
		
		emp.setEmpContacts(newEmpContactList);
		emp.setEmpDetails(newEmployeeDetail);
		
		return emp;
	}
	
	public List<EmployeeMaster> getAllEmploye(){
		
		return (List<EmployeeMaster>) employeMasterRepository.findAll();
	}
	
	public EmployeeDetails getEmploye(String empid){
		return employeDetailRepository.findById(Integer.valueOf(empid)).get();
	}
	
}
