package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.yrgo.dataaccess.StudentNotFoundException;
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
	@Path("{studentId}")
	public Student findStudentById(@PathParam("studentId") int id) {
		return service.getById(id);
	}
	
	@GET
	@Produces("application/JSON")
	public List<Student> getAllStudent() {
		return service.getAllStudents();
	}

	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Student createStudent(Student student) {
		service.registerStudent(student);
		return student;
	}

	@DELETE
	@Path("{studentId}")
	public Response deleteStudent(@PathParam("studentId") int id) {
		try {
			service.deleteStudent(id);
			return Response.status(204).build();
		} catch (StudentNotFoundException e) {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("{studentId}")
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response updateStudent(@PathParam("studentId") int id, Student s) {
		try {
			service.updateStudent(id, s.getSchoolClass(), s.getSubjects());
			return Response.ok(service.getById(id)).build();
		} catch (StudentNotFoundException e) {
			return Response.status(404).build();
		}
	}

}