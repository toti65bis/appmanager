package com.airhacks.quarkee.application;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/applications")
@Consumes("application/json")
@Produces("application/json")
public class ApplicationResource {

	
	@POST
	public Response create(Application application) {
		application.persist();
		return Response.status(201).build();
	}
	
	
	@GET
	@Path("/{owner}")
	public List<Application> findByOwner(@PathParam("owner") String owner) {
		return Application.findByOwner(owner);
	}
}
