package com.simplilearn.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.simplilearn.entity.ClassRoom;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;

public class HibernateUtil {
	
	private static SessionFactory sf;
	public static SessionFactory getSessionFactory() {
		
		if(sf == null) {
			try {
				Configuration cfg = new Configuration();
				
				Properties hibernateProperties = new Properties();
				hibernateProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				hibernateProperties.put(Environment.URL, "jdbc:mysql://localhost:3306/phaseEndProject");
				hibernateProperties.put(Environment.USER, "root");
				hibernateProperties.put(Environment.PASS, "Sainikesh@399");
				hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
				hibernateProperties.put(Environment.SHOW_SQL, "true");
				hibernateProperties.put(Environment.FORMAT_SQL, "true");
				hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
				cfg.setProperties(hibernateProperties);
				
				cfg.addAnnotatedClass(Student.class);
				cfg.addAnnotatedClass(ClassRoom.class);
				cfg.addAnnotatedClass(Teacher.class);
				cfg.addAnnotatedClass(Subject.class);
				
				ServiceRegistry sr = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties()).build();
				sf = cfg.buildSessionFactory(sr);
	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sf;	
	}

}
