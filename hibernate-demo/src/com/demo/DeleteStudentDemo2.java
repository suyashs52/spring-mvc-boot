package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Student;

public class DeleteStudentDemo2 {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			int studentId = 6;
			// get the session and start the transacation
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve the student based on id
			System.out.println("\n getting the student id with " + studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("\n Deleting student object .." + student);
			// deleting the student
			session.delete(student);
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			// update email for student id 7
			System.out.println("Delete  id 7");

			session.createQuery("delete from Student where id=7").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
