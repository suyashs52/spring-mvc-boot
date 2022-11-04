package com.demo;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Course;
import com.demo.jdbc.entity.InstructionDetail;
import com.demo.jdbc.entity.Instructor;
import com.demo.jdbc.entity.Review;
import com.demo.jdbc.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructionDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			Course course = new Course("Pacmen - How to score One Million Point");
			System.out.println("Saving the course");
			session.save(course);

			Student st = new Student("John", "Doe", "john@gaml.com");
			Student st3 = new Student("Mary", "Public", "mary@cour.com");

			st.addCourse(course);
			st3.addCourse(course);
			System.out.println("Saving the students..." + st);
			session.save(st3);
			session.save(st);
			session.getTransaction().commit();

			session.beginTransaction();

			Course rubikCourse = new Course("Rubik's Cube - How to speed up cube");
			Course atariCourse = new Course("Atari 2600 - Game Development");
			st = new Student("John1", "Doe", "john@gaml.com");

			rubikCourse.addStudent(st);
			atariCourse.addStudent(st);
			System.out.println("Saving the all course");
			session.save(st);
			session.save(rubikCourse);
			session.save(atariCourse);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();// close the connection so no leaking when exception
			factory.close();
		}
	}

}
