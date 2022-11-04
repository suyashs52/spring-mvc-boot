package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.InstructionDetail;
import com.demo.jdbc.entity.Instructor;
import com.demo.jdbc.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructionDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create an instructor object
			Instructor instructor = new Instructor("John", "Doe", "john@gamel.com");
			InstructionDetail instructionDetail = new InstructionDetail("www.youtube.com/john", "Music , coding");
			Instructor instructor1 = new Instructor("Madhue", "Patel", "madhu@gamel.com");
			InstructionDetail instructionDetail1 = new InstructionDetail("www.youtube.com/madhu", "Guitar");

			// associate the object
			instructor.setInstructionDetail(instructionDetail);
			instructor1.setInstructionDetail(instructionDetail1);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("saving the instructor");
			session.save(instructor); // save the instructor detail becuase of cascade.all, apply same to related
										// entity
			session.save(instructor1);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			System.out.println("Deleting the entity");
			session = factory.getCurrentSession();
			session.beginTransaction();
			Instructor temp = session.get(Instructor.class, instructor.getId());
			System.out.println("Found instructor: " + temp);
			if (temp != null) {
				System.out.println("Deleting..." + temp);
				session.delete(temp); // delete detail obj too
			}
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
