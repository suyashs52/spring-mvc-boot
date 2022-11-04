package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Customer3;

@Repository // use for data access object class, can change checked exception to uncheck
			// exception
public class CustomerDAOImpl4 implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory; // autowired inject bean with sessionFactory id, SessionFactory is abstract
											// class

	@Override
	// @Transactional // automatically add session.begintransaction and
	// session.gettrasaction().commit() in between query
	public List<Customer3> getCutomer() {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer3> query = session.createQuery("from Customer3 order by lastName", Customer3.class);

		// execute the query
		List<Customer3> customers = query.getResultList();

		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer3 customer) {
		Session session = sessionFactory.getCurrentSession();
		// session.update(customer); if id has value it update
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer3 getCutomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer3.class, customerId);

	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		 
		Query theQuery=session.createQuery("delete from Customer3 where id:theid");
		theQuery.setParameter("theid", customerId);
		theQuery.executeUpdate();
		
	}

}
