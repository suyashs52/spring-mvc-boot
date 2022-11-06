package com.demo.json;

import java.io.File;

import com.demo.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String... str) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			// read json file
			// convert to student pojo
			//Student st = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student st = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print first name and last name
			System.out.println("Student First Name: " + st.getFirstName() + " Last Name: " + st.getLastName());
			System.out.println( st.getAddress());
			System.out.println(
					"Student Address Street ,City: " + st.getAddress().getStree() + ", " + st.getAddress().getCity());

			for (String lang : st.getLanguage())
				System.out.println("Language: " + lang);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
