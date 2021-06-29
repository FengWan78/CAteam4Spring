package com.example.cateam4spring.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;	
	private double GPA;
	private Date enrollmentDate;

	public Student(String username, String password, boolean enabled, Integer id, String firstName, String lastName) {
		super(username, password, enabled);
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
	}

	@OneToMany(mappedBy="student")
	 private Collection<Enrolment> enrolments;

	public Student(String username, String password, boolean enabled, String firstName, String lastName, double GPA, Date enrollmentDate) {
		super(username, password, enabled);
		this.firstName = firstName;
		this.lastName = lastName;
		this.GPA = GPA;
		this.enrollmentDate = enrollmentDate;
	}
}
