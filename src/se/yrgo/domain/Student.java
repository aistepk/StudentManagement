package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String lastName;
	private String schoolClass;
	private int subjects;

	
	public Student(String firstName, String lastName, String schoolClass, int subjects) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolClass = schoolClass;
		this.subjects = subjects;
	}
	
	public Student() {
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

	public void setSubjects(int subjects) {
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public int getSubjects() {
		return subjects;
	}

	public String toString() {
	    return "Student: " + this.firstName + " " + this.lastName + " " + this.schoolClass + " " + this.subjects;
	}
}
