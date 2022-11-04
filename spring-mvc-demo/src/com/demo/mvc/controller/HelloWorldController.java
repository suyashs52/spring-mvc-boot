package com.demo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// show the initial form
	@RequestMapping("showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// process the form
	@RequestMapping("processForm")
	public String processForm() {
		return "helloWorld";
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

	
	@RequestMapping("processFormV3") //using request binding parameter, spring automatically do this for us
	public String processFormV3(@RequestParam("studentName") String theName, Model model) {

		// read the req data from html form
		 
		String param = "Hey my friend from V3! " + theName.toUpperCase();
		model.addAttribute("message", param);
		return "helloWorld";
	}

}
