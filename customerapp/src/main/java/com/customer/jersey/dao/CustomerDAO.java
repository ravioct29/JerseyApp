package com.customer.jersey.dao;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.customer.jersey.model.Customer;
import com.customer.jersey.util.SessionUtil;

public class CustomerDAO {

	public Integer addCustomer(Customer customer, int conversionId) {

		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		customer.setConversionId(conversionId);
		customer.setBillingAccountNumber(ThreadLocalRandom.current().nextInt(999999999));
		session.save(customer);
		tx.commit();
		session.close();

		return customer.getBillingAccountNumber();
	}

	public List<Customer> getCustomers() {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		session.close();
		return customers;

	}

	public Customer findByBillingNumber(int billingAccountNumber) {
		Session session = SessionUtil.getSession();
		Customer customer = (Customer) session.get(Customer.class, billingAccountNumber);
		session.close();
		return customer;

	}

	public int updateCustomer(int billingAccountNumber, Customer customer) {

		if (billingAccountNumber <= 0)
			return 0;
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Customer set email=:email, street=:street, "
				+ "zip=:zip where billingAccountNumber =:billingAccountNumber";
		Query query = session.createQuery(hql);
		query.setInteger("billingAccountNumber", billingAccountNumber);
		query.setString("email", customer.getEmail());
		query.setString("street", customer.getStreet());
		query.setString("zip", customer.getZip());

		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);

		tx.commit();
		session.close();
		return rowCount;

	}

	public int deleteCustomer(int billingAccountNumber) {

		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Customer where billingAccountNumber = :billingAccountNumber";
		Query query = session.createQuery(hql);
		query.setInteger("billingAccountNumber", billingAccountNumber);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;

	}

}
