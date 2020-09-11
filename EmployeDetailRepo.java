package com.employee.crudoperation.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.crudoperation.model.EmployeeDetails;

public interface EmployeDetailRepo extends CrudRepository<EmployeeDetails, Integer> {

}
