package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String... strings) {
		// hibernate-->jdbc-->database
		// generate entity in database using hibernate

		// sessionFactory: read hibernate config file, create session object, heavy
		// weight object, create once in app, resuse over again adn again
		// session: wrapper around jdbc connection, use to save and retrive object ,
		// short lived obje,
		// retrive from session factory, use session then throw away
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {

			System.out.println("connecting to database..." + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successfull!!!!");
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

}
