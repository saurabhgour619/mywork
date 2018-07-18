package com.cg.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.cg.dao.DtiProductDaoImp;
import com.cg.dao.EmployeeDao;

@Path("/base")
public class Controller {
	EmployeeDao empDao = new EmployeeDao();
	DtiProductDaoImp dao = new DtiProductDaoImp();
	

	@Path("/empjson")
	@GET
	public Response get() {
		return Response.status(200).entity(empDao.getAllDetails()).build();
	}

	@Path("/db/product/{id}")
	@GET
	public Response get(@PathParam("id") String id) throws Exception {
		return Response.status(200).entity(dao.getPdt(id)).build();
	}

	@Path("/text")
	@GET
	public Response read() {
		return Response.status(200).entity(empDao.getText()).build();
	}

}