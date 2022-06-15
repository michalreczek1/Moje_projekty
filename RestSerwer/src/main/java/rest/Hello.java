package rest;

import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path ("/")
public class Hello {
	@GET
	public String hello ( ) {
	return "Hello REST";
}
@Path ("/czas")
	@GET
	public String czas ( ) {
		return "Teraz jest: " + LocalDateTime.now().toString();
	}
	
}
