package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_subject", 
		joinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "id") })
	private List<Subject> subjects;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public Teacher() {
		super();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ",email=" + email +", subjects= "+ subjects + "]";
	}
	public Teacher(String name, String email, List<Subject> subjects) {
		super();
		this.name = name;
		this.email = email;
		this.subjects = subjects;
	}
}