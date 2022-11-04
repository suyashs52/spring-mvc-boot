package com.demo;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Course;
import com.demo.jdbc.entity.InstructionDetail;
import com.demo.jdbc.entity.Instructor;
import com.demo.jdbc.entity.Review;

public class CreateCourseandReviewDemo {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructionDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			Course course = new Course("Pacman - How to win game1");
			course.addReview(new Review("Great Course ... loved it"));
			course.addReview(new Review("Cool courses, Job well done!"));
			course.addReview(new Review("What a dumb course, you are an Idiot!"));
			session.save(course);
			session.getTransaction().commit();

			System.out.println("\n Delete the course");
			session = factory.getCurrentSession();

			session.beginTransaction();

			session.delete(course);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();// close the connection so no leaking when exception
			factory.close();
		}
	}

}
