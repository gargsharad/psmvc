package com.sharad.psmvc.rest.resource;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sharad.psmvc.domain.Customer;

@Path(value = "/customers")
@Singleton
public class CustomerResource {
	private Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
	private AtomicInteger idCounter = new AtomicInteger();

	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response createCustomer(@Valid Customer cust) {
		Customer customer = cust;
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		return Response.created(URI.create("customers/" + customer.getId()))
				.build();
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Customer getCustomer(@NotNull(message="{not.null}") @PathParam("id") int id) {
		return customerDB.get(id);
	}
	
	
	@PUT
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void updateCustomer(@NotNull(message="{not.null}") @PathParam("id") int id, Customer cust) {
	    Customer current = customerDB.get(id);
	    current.setCity(cust.getCity());
	    current.setCountry(cust.getCountry());
	    current.setFirstName(cust.getFirstName());
	    current.setLastName(cust.getLastName());
	    current.setState(cust.getState());
	    current.setStreet(cust.getStreet());
	    current.setZip(cust.getZip());
	    
	    customerDB.put(id, current);
	    
	}
}
