package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Student;

public class ReadStudentDem04 {

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
			Student stu = new Student("Daffy", "Duck", "daffy@glas.com");

			// start a transaction
			session.beginTransaction();
			// save the java obj
			System.out.println("saving the object");
			System.out.println(stu);
			session.save(stu);
			System.out.println("saving the student");
			// commit the transaction
			session.getTransaction().commit();

			// new generated id
			System.out.println("Saved student, generated id: " + stu.getId());
			// get the session and start the transacation
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve the student based on id
			Student student = session.get(Student.class, stu.getId());
			System.out.println("Student get id idetail: " + student);
			System.out.println("Done!");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
