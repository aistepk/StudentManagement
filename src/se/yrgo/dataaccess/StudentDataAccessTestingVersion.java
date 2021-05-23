package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import se.yrgo.domain.Student;

@Stateless
@TestingDao
public class StudentDataAccessTestingVersion implements StudentDataAccess {

	
	@Override
	public void insert(Student newStudent) {
	}

	@Override
	public List<Student> findAll() {
		Student student1 = new Student("Jane","Doe","9-A", 12);
		Student student2 = new Student("John","Doe","8-B", 11);
	    List<Student> students = new ArrayList<Student>();
	    students.add(student1);
	    students.add(student2);
	    return students;
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		return null;
	}

}