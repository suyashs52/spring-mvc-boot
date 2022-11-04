package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Customer3;
import com.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController2 {
	// error: name="dataSource" ref="myDataSource" used value in web.xml file
	// use packageToScan instead of packagesToScan

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {
		// pupulating data :setter, getting data:get in form.jsp too
		List<Customer3> theCustomer = customerService.getCustomer();

		model.addAttribute("customers", theCustomer);
		return "list-customer";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Customer3 customer = new Customer3();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer3 customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {

		// get the customer
		Customer3 customer = customerService.getCustomer(customerId);

		// set the customer in model
		model.addAttribute("customer", customer);

		// sent to over form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int customerId) {

		customerService.deleteCustomer(customerId);

		// sent to over form
		return "redirect:/customer/list";
	}

}
