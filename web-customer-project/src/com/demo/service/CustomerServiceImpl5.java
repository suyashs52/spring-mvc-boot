package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer3;

@Service // use service facade design pattern, middleware between controller and dao
public class CustomerServiceImpl5 implements CustomerService {
//service manages the transactional 
	// can interact with various dao layer
	// customer service can interact with customer dao, sales dao, license dao, all
	// dao can have different databases
	// need to inject customer dao
	
	//in service layer if we want to deposit and withdraw from a bank
	//if fail than rollback then we use same trasactional and commit/ rollback 
	@Autowired
	private CustomerDAO customerDao;

	@Override
	@Transactional
	public List<Customer3> getCustomer() {
		 
		return customerDao.getCutomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer3 customer) {
		customerDao.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer3 getCustomer(int customerId) {
		return customerDao.getCutomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
		
	}

}
