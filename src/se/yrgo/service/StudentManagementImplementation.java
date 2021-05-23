package se.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.ProductionDao;
import se.yrgo.dataaccess.StudentDataAccess;
import se.yrgo.dataaccess.TestingDao;
import se.yrgo.domain.Student;

@Stateless
public class StudentManagementImplementation implements StudentManagementService, StudentManagementServiceLocal {

	@Inject
	@ProductionDao
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
	
}
