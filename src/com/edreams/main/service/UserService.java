package com.edreams.main.service;

import java.util.Collection;

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

import com.edreams.main.bean.User;
import com.edreams.main.controller.ControllerUserService;

@Path("/userService/")
public class UserService {
	private ControllerUserService controllerUserService;


	public UserService() throws Exception {
		super();
		controllerUserService = new ControllerUserService();	
		controllerUserService.startDB();
	}

	@GET
	@Path("/getUser/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") Integer id) {		
		return controllerUserService.getUser(id);
	}
	
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUsers() {	
		return controllerUserService.getUsers();
	}


	@PUT
	@Path("/updateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) throws Exception {		
		controllerUserService.updateUser(user);		
		return Response.status(201).entity(user.toString()).build();
	}
	@POST
	@Path("/insertUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User insertUser(User user) throws Exception {
		controllerUserService.insertUser(user);
		return user;
		
	}
	
	@DELETE
	@Path("/deleteUser")
	public Response deleteUser(User user) throws Exception {
		controllerUserService.deleteUser(user);	
		return Response.status(201).entity(user.toString()).build();
	}
				
		
		
}
