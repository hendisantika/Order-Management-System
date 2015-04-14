package com.hendi.oms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hendi.oms.model.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		logger.info("Customer saved successfully. Customer details = " + customer);
		
	}
	@Override
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
		logger.info("Customer updated successfully. Customer details = " + customer);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		for(Customer c : customerList){
			logger.info("Customer List :: " + c);
		}
		return customerList;
	}
	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer (id));
		logger.info("Customer loaded successfully. Customer details = " + customer);
		return customer;
	}
	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class,new Integer(id));
		if(null != customer){
			session.delete(customer);
		}
		logger.info("Customer deleted succesfully. Customer details = " + customer );
		
	}
	
	

}
