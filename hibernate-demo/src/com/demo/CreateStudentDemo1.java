package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Student;

public class CreateStudentDemo1 {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// use session to save the student obje
			System.out.println("Creating new student object");
			// create a student object
			Student stu = new Student("paul", "wall", "paul@glas.com");

			// start a transaction
			session.beginTransaction();
			// save the java obj
			session.save(stu);
			System.out.println("saving the student");
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
