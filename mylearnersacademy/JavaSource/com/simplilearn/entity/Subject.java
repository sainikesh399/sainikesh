package com.simplilearn.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subjectName;
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return subjectName;
	}
	public void setName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	public Subject() {
		super();
	}
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + "]";
	}

}