package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

public class TeacherDao {

	public Teacher getTeacher(int id) {
		Transaction transaction = null;
		Teacher teacher = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return teacher;
	}

	public Teacher saveTeacher(Teacher teacher) {
		Transaction transaction = null;
		Teacher createdTeacher = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the teacher object
			session.save(teacher);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return createdTeacher;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeachers() {
		Transaction transaction = null;
		List<Teacher> listOfTeachers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an student object
			listOfTeachers = session.createQuery("from Teacher").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfTeachers;
	}
}