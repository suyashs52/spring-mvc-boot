package com.demo.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mvc.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	 // add initbinder ..call on all form submit 
	//to convert trim input strings 
	//pre process every string from data if string has white space trim it to null
	@InitBinder
	public void initbinder(WebDataBinder theBinder) {
		System.out.println("Init binder called...");
		StringTrimmerEditor trimmerEditor=new StringTrimmerEditor(true);//true means trim to null
		theBinder.registerCustomEditor(String.class,trimmerEditor);
		}	
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("customer", new Customer());
		return "customer-form";

	}

	@RequestMapping("/processForm")
	public String processFrom(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
//@Valid perform validation rulue on customer object
		// spring place the result in binding result
		// binding result must follow model attribute

		System.out.println("Binding Result: "+bindingResult);
		System.out.println("\n\n\n\n");
		if (bindingResult.hasErrors()) {
			return "customer-form";
		} else
			return "customer-confirmation";

	}
}
