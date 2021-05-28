package se.yrgo.client;

import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementService;

import javax.naming.Context;
import javax.naming.InitialContext;


public class Main {

	public static void main(String[] args) throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		
		Context jndi = new InitialContext(jndiProperties);
		
		StudentManagementService service = 
	               (StudentManagementService)jndi.lookup("StudentManagementApplication/StudentManagementImplementation!se.yrgo.service.StudentManagementService");
		
//		Student student1 = new Student("Ana","Johnsson","7-A",12);
//		Student student2 = new Student("Brian","Griffin","9-C",12);
//		Student student3 = new Student("Homer","Simpson","5-B",11);
//		Student student4 = new Student("Maggie","Simpson","4-C",10);
		Student student5 = new Student("Lisa","Simpson","5-D",11);
		
//		service.registerStudent(student1);
//		service.registerStudent(student2);
//		service.registerStudent(student3);
//		service.registerStudent(student4);
		service.registerStudent(student5);

		
//		List<Student> students = service.getAllStudents();
//		for (Student student: students) {
//		    System.out.println(student);
//		}
		
		List<Student> students = service.searchBylastName("Simpson");
		for (Student student: students) {
		System.out.println(student);
		}
		
	}

}
