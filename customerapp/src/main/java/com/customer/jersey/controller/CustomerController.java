package com.customer.jersey.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.customer.jersey.dao.CustomerDAO;
import com.customer.jersey.model.Customer;



@Path("customer")
public class CustomerController {
	
		CustomerDAO dao = new CustomerDAO();		
		
		@GET
		@Produces("application/json")
		@Path("/customers")
		public List<Customer> getCustomers(){
			
			List customers = dao.getCustomers();
			return customers;
			
			
		}
		
		@POST
		@Path("/create")
		@Consumes("application/json")
		public Response addCustomer(@Valid Customer customer, @HeaderParam("conversionId") int conversionId) {
			
			Integer addCustomer = dao.addCustomer(customer, conversionId);
			if(addCustomer != null) {
				return Response.status(Response.Status.OK).entity(customer.getBillingAccountNumber()).build();
			}
				return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		@GET
		@Path("/findByBillingNumber/{billingAccountNumber}")
		@Consumes("application/json")
		public Response findByBillingNumber(@PathParam("billingAccountNumber") int billingAccountNumber, Customer customer) {
			
			Customer findByBillingNumber = dao.findByBillingNumber(billingAccountNumber);
			
			if(findByBillingNumber != null) {
				return Response.status(Response.Status.OK).entity(findByBillingNumber).build();
			}
			return Response.status(Response.Status.NOT_FOUND).build();

			}
	
		@PUT
		@Path("/update/{billingAccountNumber}")
		@Consumes("application/json")
		public Response updateCustomer(@PathParam("billingAccountNumber")int id, Customer customer) {
			int count = dao.updateCustomer(id, customer);
			if(count == 0) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			
			return Response.ok().build();
		}
		@DELETE
		@Path("/delete/{billingAccountNumber}")
		public Response deleteCustomer(@PathParam("billingAccountNumber") int billingAccountNumber) {
			
			int count = dao.deleteCustomer(billingAccountNumber);
			if(count == 0) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			
			return Response.ok().build();
		}
		
		
		}


