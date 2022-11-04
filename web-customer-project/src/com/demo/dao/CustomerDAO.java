package com.demo.dao;

import java.util.List;

import com.demo.entity.Customer3;

public interface CustomerDAO {

	public List<Customer3> getCutomer();

	public void saveCustomer(Customer3 customer);

	public Customer3 getCutomer(int customerId);

	public void deleteCustomer(int customerId);
}
