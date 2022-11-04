package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Student;

public class PrimaryKeyDemo3 {

	public static void main(String[] args) {

		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// use session to save the student obje
			System.out.println("Creating 3 students object");
			// create 3 students object
			Student john = new Student("John", "Deos", "john@glas.com");
			Student mary = new Student("Mary", "Public", "mary@glas.com");
			Student bonita = new Student("Bonita", "Balm", "bonita@glas.com");

			// start a transaction
			session.beginTransaction();
			// save the java obj
			session.save(john);
			session.save(mary);
			session.save(bonita);
			System.out.println("saving the 3 students");
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
