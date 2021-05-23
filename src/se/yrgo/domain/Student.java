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

	public String toString() {
	    return "Student: " + this.firstName + " " + this.lastName + " " + this.schoolClass + " " + this.subjects;
	}
}
