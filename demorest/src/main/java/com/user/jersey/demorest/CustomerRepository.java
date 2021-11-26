package com.user.jersey.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
	Connection con = null;

	public CustomerRepository() {

		String url = "jdbc:mysql://localhost/restdb";
		String username = "root";
		String password = "root";

		try {
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver() );
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);
		}

		catch (Exception e) {

			System.out.println(e);
		}

	}

	public List<Customer> getCustomers() {

		List<Customer> customerList = new ArrayList<Customer>();

		String sql = "select * from customer";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setBillingAccountNumber(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setPhoneNumber(rs.getString(4));
				customer.setStreet(rs.getString(5));
				customer.setCity(rs.getString(6));
				customer.setState(rs.getString(7));
				customer.setZip(rs.getInt(8));
				customer.setEmailId(rs.getString(9));
				customerList.add(customer);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return customerList;
	}

	public Customer getCustomer(int billingAccountNumber) {

		Customer customer = new Customer();
		String sql = "select * from customer where billingAccountNumber=" + billingAccountNumber;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				customer.setBillingAccountNumber(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setPhoneNumber(rs.getString(4));
				customer.setStreet(rs.getString(5));
				customer.setCity(rs.getString(6));
				customer.setState(rs.getString(7));
				customer.setZip(rs.getInt(8));
				customer.setEmailId(rs.getString(9));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return customer;
	}

	public  void createCustomer(Customer customer) {

		String sql = "insert into customer(billingAccountNumber,firstName,lastName,"
				+ "phoneNumber,street,city,state,zip,emailId) values(?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, customer.getBillingAccountNumber());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getPhoneNumber());
			ps.setString(5, customer.getStreet());
			ps.setString(6, customer.getCity());
			ps.setString(7, customer.getState());
			ps.setInt(8, customer.getZip());
			ps.setString(9, customer.getEmailId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateCustomer(Customer customer, int  billingAccountNumber) {

		String sql = "update customer set street=?,city=?,state=?,zip=?,emailId where billingAccountNumber=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,customer.getStreet());
			ps.setString(3, customer.getCity());
			ps.setString(4, customer.getState());
			ps.setInt(5, customer.getZip());
			ps.setString(6, customer.getEmailId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public boolean deleteCustomer(int billingAccountNumber) {
		String sql = "delete from customer where billingAccountNumber="+billingAccountNumber;
		try {
			PreparedStatement st = con.prepareStatement(sql);	
			st.setInt(1, billingAccountNumber);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return true;
	}

}