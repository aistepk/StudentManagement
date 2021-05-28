package se.yrgo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.StudentDataAccess;
import se.yrgo.dataaccess.StudentNotFoundException;
import se.yrgo.domain.Student;

@Stateless
public class StudentManagementImplementation implements StudentManagementService, StudentManagementServiceLocal {

	@Inject
	private StudentDataAccess dao;
	
	@Override
	public void registerStudent(Student student) {	
		dao.insert(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return dao.findAll();
	}

	@Override
	public List<Student> searchBylastName(String lastName) {
		return dao.findByLastName(lastName);
	}
	
	@Override
	public Student getById(int id) {
        return dao.findById(id);
    }
	
	@Override
	public void updateStudent(int id, String schoolClass, int subjects) {
	    dao.updateStudent(id, schoolClass, subjects);
	}
	
	@Override
	public void deleteStudent(int id) throws StudentNotFoundException {
	    dao.deleteStudent(id);
	}


}