package com.demo.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);
		// add the country options to the model 
		model.addAttribute("countryOptions", countryOptions); 
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// log the input data
		System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}

}
