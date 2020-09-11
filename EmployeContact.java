package com.employee.crudoperation.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class EmployeContact implements Serializable {
	
	private static final long serialVersionUID = -2348946164930731345L;

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ecid;
	
	@ManyToOne
    @JoinColumn(name="empmaster_id", nullable=true)
    private EmployeeMaster empMasterContact;
	
	@Column
	String addressType;
	
	@Column
	String addressLine1;
	
	@Column
	String addressLine2;
	
	@Column
	String pincode;
	
	@Column
	String city;
	
	@Column
	String state;
	
	@Column
	String country;
	
	@Column
	String status;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Calendar created_date;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Calendar updated_date;



	public int getEcid() {
		return ecid;
	}

	public void setEcid(int ecid) {
		this.ecid = ecid;
	}

	public EmployeeMaster getEmpMasterContact() {
		return empMasterContact;
	}

	public void setEmpMasterContact(EmployeeMaster empMasterContact) {
		this.empMasterContact = empMasterContact;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
