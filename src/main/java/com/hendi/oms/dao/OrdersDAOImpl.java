package com.hendi.oms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hendi.oms.model.Customer;
import com.hendi.oms.model.Orders;

public class OrdersDAOImpl implements OrdersDAO{
	private static final Logger logger = LoggerFactory.getLogger(OrdersDAOImpl.class);
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrders(Orders o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(o);
		logger.info("Orders saved successfully. Orders details = " + o);
	}

	@Override
	public void updateOrders(Orders o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
		logger.info("Orders updated successfully. Orders details = " + o);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> listOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Orders> ordersList = session.createQuery("from Orders").list();
		for(Orders o : ordersList){
			logger.info("Orders List :: " + o);
		}
		return ordersList;
	}

	@Override
	public Orders getOrdersById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Orders orders = (Orders) session.load(Orders.class, new Integer(id));
		logger.info("Orders loaded succesfully. Orders details = " + orders);
		return orders;
	}

	@Override
	public void removeOrders(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Orders orders = (Orders) session.load(Orders.class, new Integer(id));
		if(null != orders){
			session.delete(orders);
		}
		logger.info("Orders deleted succesfully. Orders details = " + orders);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getCustomername() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Orders> ordersList = session.createQuery("select Customer from Orders").list();
		return ordersList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomer() {
		return sessionFactory.getCurrentSession().createSQLQuery("SELECT cusFirstname, cusLastname FROM Customer").list(); 
	}
	
	

}
