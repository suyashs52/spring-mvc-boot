package com.demo.service;

import java.util.List;

import com.demo.entity.Customer3;

public interface CustomerService {

	public List<Customer3> getCustomer();

	public void saveCustomer(Customer3 customer);

	public Customer3 getCustomer(int customerId);

	public void deleteCustomer(int customerId);

}
