package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Student;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
//restcontroller return as json, controller as string/jsp page
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello User!";
	}

	List<Student> stu;

	// add apache server lib
	// postConstruc only call once
	@PostConstruct
	public void loadData() {
		stu = new ArrayList<Student>();
		stu.add(new Student("Poornima", "Patel"));
		stu.add(new Student("Mooria", "Lati"));
		stu.add(new Student("Mari", "Smith"));

	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return stu;

	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (studentId > stu.size() || studentId < 0) {
			throw new NotFoundException("Student Id not Found " + studentId);
		}

		return stu.get(studentId);

	}

	// add an exception handler using @exception handler

//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleStudentNotFound(StudentNotFoundException exc) {
//		// create a student response
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setMessage(exc.getMessage());
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setTimestamp(System.currentTimeMillis());
//
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
//		// return
//	}
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleStudentException(Exception exc) {
//		// create a student response
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setMessage(exc.getMessage());
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setTimestamp(System.currentTimeMillis());
//
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
//		// return
//	}
}
