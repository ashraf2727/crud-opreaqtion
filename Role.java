package com.employee.crudoperation.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Role implements Serializable {
	
	
	private static final long serialVersionUID = -8518388708968426546L;

	@Id
	@Column
	int roleId;
	
	@Column
	String role;
	
	@Column
	String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Calendar created_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	Calendar updated_date;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
