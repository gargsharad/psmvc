package psmvc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sharad.psmvc.domain.Customer;

public class CustomerResourceTest {

    public static void main(String[] args) {
	Client client = ClientBuilder.newClient();
	try {
	    System.out.println("*** Create a new Customer ***");
	    String xml = "<customer>" + "<first-name></first-name>" + "<last-name></last-name>" + "<street>256 Clarendon Street</street>"
		    + "<city>Boston</city>" + "<state>MA</state>" + "<zip>02115</zip>" + "<country>USA</country>" + "</customer>";
	    Response response = client.target("http://localhost:8080/psmvc/services/customers").request(MediaType.APPLICATION_XML).post(Entity.xml(xml));
	    response.bufferEntity();
	    System.out.println(response.readEntity(String.class));
	    if (response.getStatus() != 201)
		throw new RuntimeException("Failed to create");
	    String location = response.getLocation().toString();
	    System.out.println("Location: " + location);
	    response.close();
	    System.out.println("*** GET Created Customer **");
	    Customer customer = client.target(location).request().get(Customer.class);
	    System.out.println(customer);
	    String updateCustomer = "<customer>" + "<first-name>William</first-name>" + "<last-name>Burke</last-name>"
		    + "<street>256 Clarendon Street</street>" + "<city>Boston</city>" + "<state>MA</state>" + "<zip>02115</zip>" + "<country>USA</country>"
		    + "</customer>";
	    response = client.target(location).request().put(Entity.xml(updateCustomer));
	    if (response.getStatus() != 204)
		throw new RuntimeException("Failed to update");
	    response.close();
	    System.out.println("**** After Update ***");
	    customer = client.target(location).request().get(Customer.class);
	    System.out.println(customer);
	} finally {
	    client.close();
	}
    }

}
