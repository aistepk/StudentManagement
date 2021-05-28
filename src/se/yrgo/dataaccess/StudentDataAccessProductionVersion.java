package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.yrgo.domain.Student;

@Stateless
public class StudentDataAccessProductionVersion implements StudentDataAccess {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Student newStudent) {
		em.persist(newStudent);
	}

	@Override
	public List<Student> findAll() {
		Query q = em.createQuery("select student from Student student");
	    List<Student> students = q.getResultList();
	    return students;
	}

	@Override
	public List<Student> findByLastName(String lastName) {
	    Query q = em.createQuery("select student from Student student where student.lastName = :lastName");
	    q.setParameter("lastName", lastName);
	    return q.getResultList();
	}
	
	@Override
	public Student findById(int id) {
	    Query q = em.createQuery("select student from Student student where student.id = :id");
	    q.setParameter("id", id);
	    return (Student)q.getSingleResult() ;
	}
	
	@Override
	public void updateStudent(int id, String schoolClass, int subjects) {
	    Student s = findById(id);
	    s.setSchoolClass(schoolClass);
	    s.setSubjects(subjects);
	}

	@Override
	public void deleteStudent(int id) throws StudentNotFoundException {
		Student s = findById(id);
	    em.remove(s);
	}


}