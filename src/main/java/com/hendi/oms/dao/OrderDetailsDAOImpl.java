package com.hendi.oms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hendi.oms.model.OrderDetails;

@Repository
public class OrderDetailsDAOImpl implements OrderDetailsDAO{
	private static Logger logger = LoggerFactory.getLogger(OrderDetailsDAOImpl.class);
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrderDetails(OrderDetails od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(od);
		logger.info("OrderDetails saved succesfully. OrderDetails : " + od);
	}

	@Override
	public void updateOrderDetails(OrderDetails od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(od);
		logger.info("OrderDetails updated successfully. OrderDetails : " + od);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> listOrderDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<OrderDetails> orderDetailsList = session.createQuery("from OrderDetails").list();
		for(OrderDetails od : orderDetailsList){
			logger.info("OrderDetails List :: " + od);
		}
		return orderDetailsList;
	}

	@Override
	public OrderDetails getOrderDetailsbyId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OrderDetails orderDetails = (OrderDetails) session.load(OrderDetails.class,  new Integer(id));
		logger.info("Orderdetails loaded succesfully. Order Details : " + orderDetails);
		return orderDetails;
	}

	@Override
	public void removeOrderDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OrderDetails orderDetails = (OrderDetails) session.load(OrderDetails.class,  new Integer(id));
		if(null != orderDetails){
			session.delete(orderDetails);
		}
		logger.info("Order Details deleted succesfully. Orders details = " + orderDetails);
		
		
	}

}
