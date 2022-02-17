package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.SubjectDao;
import com.simplilearn.entity.Subject;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDao subjectDao;

	public SubjectServlet() {
		super();
	}

	public void init() {
		subjectDao = new SubjectDao();
	}

	private Subject getSubject(HttpServletRequest request, HttpServletResponse response) {
		String subjectId = request.getParameter("id");
		Subject subject = subjectDao.getSubject(Integer.parseInt(subjectId));
		return subject;
	}

	private List<Subject> getSubjects(HttpServletRequest request, HttpServletResponse response) {
		List<Subject> subjects = subjectDao.getAllSubjects();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("subjects", subjects);
			response.sendRedirect("pages/list-subjects.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjects;
	}

	private Subject createSubject(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("subjectName");

		Subject subjectModel = new Subject(name);
		Subject newSubject= subjectDao.saveSubject(subjectModel);
		getSubjects(request, response);
		return newSubject;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createSubject(request, response);
				break;

			case "list":
				getSubjects(request, response);
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