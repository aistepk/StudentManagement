package se.yrgo.service;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.dataaccess.StudentNotFoundException;
import se.yrgo.domain.Student;

@Local
public interface StudentManagementServiceLocal {
	public void registerStudent(Student student);
	public List<Student>getAllStudents();
	public List<Student>searchBylastName(String lastName);
	public Student getById(int id);
    public void updateStudent(int id, String schoolClass, int subjects) throws StudentNotFoundException;
	public void deleteStudent(int id) throws StudentNotFoundException;
}