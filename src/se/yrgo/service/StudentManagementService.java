package se.yrgo.service;

import java.util.List;
import javax.ejb.Remote;

import se.yrgo.domain.Student;

@Remote
public interface StudentManagementService {
	public void registerStudent(Student student);
	public List<Student>getAllStudents();
	public List<Student>searchBylastName(String lastName);
}