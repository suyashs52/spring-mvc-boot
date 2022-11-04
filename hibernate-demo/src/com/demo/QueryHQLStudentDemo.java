package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Student;

public class QueryHQLStudentDemo {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			// query student
			List<Student> students = session.createQuery("from Student").getResultList();

			displayStudents(students);

			// query student by last name

			students = session.createQuery("from Student s where s.lastName='wall'").getResultList();

			// display the student
			System.out.println("\n\nStudent who has last name wall\n");
			displayStudents(students);

			// query: student: lastName: 'Doe' or firstname: 'Doe'
			students = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Doe'")
					.getResultList();

			System.out.println("\n\nStudent who  lastName: 'Doe' or firstname: 'Doe'\n");
			displayStudents(students);

			// query: student: where email like glas'
			students = session.createQuery("from Student s where s.email LIKE '%glas.com'").getResultList();

			System.out.println("\n\nStudent whose  email ends with glas\n");
			displayStudents(students);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		// display the student
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
