package com.demo.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet01 extends HttpServlet {
	// add hibernate,spring , sql jdbc jar file in jdbc
	// add hibernate optional c3p0 file for connectionion pool
	// add
	// javax.activation-1.2.0.jar,jaxb-api-2.3.0.jar,jaxb-core-2.3.0.jar,jaxb-impl-2.3.0.jar
	// for java 9 and higher
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = "springstudent";
		String pass = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection to database
		try {

			PrintWriter writer = response.getWriter();
			writer.println("Connecting to db url " + jdbcUrl);
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

			writer.println("Success!!");
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
