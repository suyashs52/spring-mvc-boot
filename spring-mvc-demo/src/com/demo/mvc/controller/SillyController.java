package com.demo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {

//There is already 'helloWorldController' bean method
//Error creating bean with name  
	// so need to specify requestmapping at controller end
	// show the initial form
	@RequestMapping("showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// read form data and add data to modal
	@RequestMapping("processFormReq")
	public String shoutDude(HttpServletRequest request, Model model) {

		// read the req data from html form
		String param = request.getParameter("studentName");
		param = "YO! " + param.toUpperCase();
		model.addAttribute("message", param);
		return "helloWorld";
	}
}
