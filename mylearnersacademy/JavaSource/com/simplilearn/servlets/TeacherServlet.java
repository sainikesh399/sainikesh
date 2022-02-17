package com.simplilearn.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.TeacherDao;
import com.simplilearn.entity.Teacher;

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;

	public TeacherServlet() {
		super();
	}

	public void init() {
		teacherDao = new TeacherDao();
	}

	private Teacher getStudent(HttpServletRequest request, HttpServletResponse response) {
		String teacherId = request.getParameter("id");
		Teacher teacher = teacherDao.getTeacher(Integer.parseInt(teacherId));
		return teacher;
	}

	private List<Teacher> getTeachers(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> teachers = teacherDao.getAllTeachers();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("teachers", teachers);
			response.sendRedirect("pages/list-teachers.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	private Teacher createTeacher(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("teacherName");
		String email = request.getParameter("email");

		Teacher teacherModel = new Teacher(name, email);
		Teacher newTeacher = teacherDao.saveTeacher(teacherModel);
		getTeachers(request, response);
		return newTeacher;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createTeacher(request, response);
				break;

			case "list":
				getTeachers(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}