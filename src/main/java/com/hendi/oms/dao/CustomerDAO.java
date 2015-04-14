package com.hendi.oms.dao;

import java.util.List;

import com.hendi.oms.model.Customer;

public interface CustomerDAO {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
    
}
