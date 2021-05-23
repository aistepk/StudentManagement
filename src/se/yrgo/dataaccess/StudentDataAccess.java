package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Student;

@Local
public interface StudentDataAccess {

	public void insert(Student newStudent);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    
}
