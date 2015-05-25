package com.hendi.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hendi.oms.dao.CustomerDAO;
import com.hendi.oms.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void addCustomer(Customer c) {
		this.customerDAO.addCustomer(c);
		
	}

	@Transactional
	public void updateCustomer(Customer c) {
		this.customerDAO.updateCustomer(c);
		
	}

	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

	@Override
	public List<Customer> showCusName() {
		return this.customerDAO.showCusName();
	}

}
