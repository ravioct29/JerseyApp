package com.customer.jersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Id
	@Column(name = "billingAccountNumber")
	private int billingAccountNumber;
	
	@Column(name ="phoneNumber")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;
	
	@Column(name= "street")
	private String street;
	
	@Column(name = "zip")
	@Min(value = 11111)
	@Max(value = 99999)
	private String zip;
	
	@Column(name="state")
	@Size(min=2, max=2)
	private String state;
	
	private int conversionId;
		
	public Customer() {
		super();
	}
	public Customer(String name, String email, int billingAccountNumber, String phoneNumber, String street,
			String zip, String state, int conversionId) {
		super();
		this.name = name;
		this.email = email;
		this.billingAccountNumber = billingAccountNumber;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.zip = zip;
		this.state = state;
		this.conversionId = conversionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBillingAccountNumber() {
		return billingAccountNumber;
	}
	public void setBillingAccountNumber(int billingAccountNumber) {
		this.billingAccountNumber = billingAccountNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
	
		return state;
	}
	public void setState(String state) {
		
		this.state = state.toString().substring(0,2).toUpperCase();
	}
	public int getConversionId() {
		return conversionId;
	}
	public void setConversionId(int conversionId) {
		this.conversionId = conversionId;
	}
	
	

}
