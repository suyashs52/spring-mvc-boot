package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Course;
import com.demo.jdbc.entity.InstructionDetail;
import com.demo.jdbc.entity.Instructor;

public class CreateInstructorDemoMany {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructionDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// init instructor object
			Instructor instructor1 = new Instructor("Maria", "Public", "susan@gamel.com");
			InstructionDetail instructionDetail1 = new InstructionDetail("www.youtube.com/susan", "Video Games");
			instructor1.setInstructionDetail(instructionDetail1);
			Course c1 = new Course("Mario2");
			Course c2 = new Course("Sweets2");
			instructor1.add(c1);
			instructor1.add(c2);
			// start a transaction

			session.beginTransaction();
			session.save(instructor1);
			session.save(c1);
			session.save(c2);

			session.getTransaction().commit();

			System.out.println("get instructor by course");
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Instruction get course " + instructor1.getCourse());

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();// close the connection so no leaking when exception
			factory.close();
		}
	}

}
