package com.demo;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.entity.Course;
import com.demo.jdbc.entity.InstructionDetail;
import com.demo.jdbc.entity.Instructor;

public class EagerLazyInstructorDemo {

	public static void main(String[] args) {
		// create sesssion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructionDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction
			session.beginTransaction();

			// get the instruction detail object
			Instructor insd = session.get(Instructor.class, 10);
			System.out.println("instructor detais..." + insd);
			// when lazy call query ll again hit for course
			System.out.println("instructor Course detais..." + insd.getCourse());

			session.getTransaction().commit();
			session.close();
			System.out.println("instructor Course detais after session close..." + insd.getCourse());

			System.out.println("\n Query using HQL\n");
			session = factory.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("select i from Instructor i " + " Join fetch i.course where i.id=:theInstrutId" ,
					Instructor.class);
			//set hql parameter
			query.setParameter("theInstrutId", 10);
			
			//execute the query 
			System.out.println(query.getSingleResult());
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();// close the connection so no leaking when exception
			factory.close();
		}
	}

}
