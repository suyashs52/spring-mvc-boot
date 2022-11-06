package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Customer;
import com.demo.service.CustomerService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);

		if (customer == null) {
			throw new NotFoundException("Customer Id not Found " + id);
		}
		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0); // if >0 then it ll save the customer
		// HTTP Status 405: get / post error or by disabling http.csrf().disable();
		// in body >raw>json
		// Content-Type : application/json
		customerService.saveCustomer(customer);
		return customer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {

		Customer temp = customerService.getCustomer(id);
		if (temp == null) {
			throw new NotFoundException("Customer Id not Found " + id);
		}
		customerService.deleteCustomer(id);
		return "Deleted Customer id:-" + id;
	}

}
