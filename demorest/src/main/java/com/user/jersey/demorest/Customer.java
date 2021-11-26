package com.user.jersey.demorest;

import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	
	private int billingAccountNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private int zip;
	private String emailId;
	
	
	
	
	public Customer() {
		super();
	}
	public Customer(int billingAccountNumber, String firstName, String lastName, String phoneNumber, String street,
			String city, String state, int zip, String emailId) {
		super();
		this.billingAccountNumber = billingAccountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.emailId = emailId;
	}
	public int getBillingAccountNumber() {
		return billingAccountNumber;
	}
	public void setBillingAccountNumber(int billingAccountNumber) {
		Random random = new Random();
		random.ints(9, 99999999);
		this.billingAccountNumber =billingAccountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
