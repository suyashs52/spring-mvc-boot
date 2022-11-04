package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.InstructionDetail;
import com.demo.jdbc.entity.Instructor;
import com.demo.jdbc.entity.Student;

public class CreateInstructorDemoBi {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructionDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			// get the instruction detail object
			InstructionDetail insd = session.get(InstructionDetail.class, 2);
			System.out.println("instructor detais..." + insd);
			System.out.println("\nbidirectional instruction detail" + insd.getInstructor());

			session.getTransaction().commit();

			Instructor instructor1 = new Instructor("Madhue", "Patel", "madhu@gamel.com");
			InstructionDetail instructionDetail1 = new InstructionDetail("www.youtube.com/madhu", "Guitar");
			instructor1.setInstructionDetail(instructionDetail1);
			// saving the record
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(instructor1);
			session.getTransaction().commit();
			// deleting the instructionDetail1
			session = factory.getCurrentSession();
			session.beginTransaction();
			InstructionDetail insd1 = session.get(InstructionDetail.class, instructionDetail1.getId());
			// only delete detail need to remove the detail reference from instructor class
			// form the back reference to instr class
			// break the bidirectional mapping if not it ll thorw the exception:>deleted
			// object would be re-saved by cascade
			insd1.getInstructor().setInstructionDetail(null);
			session.delete(insd1);
			session.getTransaction().commit();
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();// close the connection so no leaking when exception
			factory.close();
		}
	}

}
