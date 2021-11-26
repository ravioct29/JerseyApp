package com.user.jersey.demorest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;




@Path("customer")
public class CustomerController {
	
	CustomerRepository repo = new CustomerRepository();		


	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Customer> getAllCustomers(){
		return repo.getCustomers();
	}
	
	@POST
	@Path("create")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response createAlien(Customer customer) {
		repo.createCustomer(customer);
		return Response.status(Status.OK).build();
	}
	
	
	@GET
	@Path("find/{billingAccountNumber}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getCustomerById(@PathParam("billingAccountNumber") int billingAccountNumber) {
	Customer find= repo.getCustomer(billingAccountNumber);
	return Response.status(Status.OK).entity(find).build();
	}
	
	@PUT
	@Path("update/{billingAccountNumber}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer updateAlien(Customer customer,@PathParam("billingAccountNumber")int billingAccountNumber) {
		repo.updateCustomer(customer, billingAccountNumber);
		return customer;
	}
	
	@DELETE
	@Path("delete/{billingAccountNumber}")
	public Response deleteCustomer(@PathParam("billingAccountNumber") int billingAccountNumber) {
		boolean belete=repo.deleteCustomer(billingAccountNumber);
		if(belete) {
		 repo.getCustomer(billingAccountNumber);
		 return Response.status(Status.NO_CONTENT).build();
	   }
		return Response.status(Status.NOT_FOUND).build();
}
}

