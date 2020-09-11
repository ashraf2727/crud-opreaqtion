package com.employee.crudoperation.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class EmployeeMaster implements Serializable{
	
	private static final long serialVersionUID = 1132269746582456946L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int empId;
	
	@OneToOne(cascade=CascadeType.PERSIST, orphanRemoval=true)
    private EmployeeDetails empDetails;
	
	@OneToMany(mappedBy="empMasterContact")
	private List<EmployeContact> empContacts;

	@Column
	String username;
	
	@Column
	String password;
	
	@Column
	String role;
	
	@Column
	String status;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Calendar created_date;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Calendar updated_date;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public EmployeeDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}

	public List<EmployeContact> getEmpContacts() {
		return empContacts;
	}

	public void setEmpContacts(List<EmployeContact> empContacts) {
		this.empContacts = empContacts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Calendar created_date) {
		this.created_date = created_date;
	}

	public Calendar getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Calendar updated_date) {
		this.updated_date = updated_date;
	}
}
