package com.sharad.psmvc.rest.resource;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sharad.psmvc.domain.Customer;

@Path(value = "/customers")
public class CustomerResource {
	private Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
	private AtomicInteger idCounter = new AtomicInteger();

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response createCustomer(Customer cust) {
		Customer customer = cust;
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		return Response.created(URI.create("customers/" + customer.getId()))
				.build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer(@PathParam("id") int id) {
		return customerDB.get(id);
	}
}
