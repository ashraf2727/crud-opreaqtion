package com.employee.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.crudoperation.model.EmployeContact;

public interface EmployeeContactRepo extends JpaRepository<EmployeContact, Integer> {
	
	//public List<EmployeContact> findByEmpmaster_id(String empmaster_id);

	//public EmployeContact findByEcid(Integer id);
}
