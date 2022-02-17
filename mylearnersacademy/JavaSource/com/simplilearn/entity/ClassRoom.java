package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String className;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_student", 
	joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id") }, 
	inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id") })
    private List<Student> students;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_teacher", 
		joinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id") })
	private List<Teacher> teachers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_subject", 
		joinColumns = { @JoinColumn(name = "subject_id", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id") })
	private List<Subject> subjects;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public ClassRoom(String className) {
		super();
		this.className = className;
	}

	public ClassRoom() {
		super();
	}

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", className=" + className + ", students=" +students +", teachers=" + teachers +", subjects="+ subjects + "]";
	}
	public ClassRoom(String className, List<Subject> subjects, List<Teacher> teachers, List<Student> students) {
		super();
		this.className = className;
		this.students = students;
		this.subjects = subjects;
		this.teachers = teachers;
	}

}