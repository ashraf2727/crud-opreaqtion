package com.employee.crudoperation.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class EmployeeDetails implements Serializable {
	
	private static final long serialVersionUID = -3900983173388493575L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int edid;
	
	@OneToOne(orphanRemoval=true)
    @JoinColumn(name = "empmaster_id",nullable=true)
	private EmployeeMaster empMasterDetail;
	
	@Column
	String salary;
	
	@Column
	String status;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Calendar created_date;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Calendar updated_date;

	public int getEdid() {
		return edid;
	}

	public void setEdid(int edid) {
		this.edid = edid;
	}

	public EmployeeMaster getEmpMasterDetail() {
		return empMasterDetail;
	}

	public void setEmpMasterDetail(EmployeeMaster empMasterDetail) {
		this.empMasterDetail = empMasterDetail;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
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
