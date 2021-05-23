package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementService;
import se.yrgo.service.StudentManagementServiceLocal;
	
@Stateless 
@Path("/students")
public class StudentResource {

	@Inject
	private StudentManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public List<Student> getAllStudent() {
		return service.getAllStudents();
	}
}