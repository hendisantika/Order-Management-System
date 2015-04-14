package com.hendi.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hendi.oms.dao.OrderDetailsDAO;
import com.hendi.oms.model.OrderDetails;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	public void setOrderDetailsDAO(OrderDetailsDAO orderDetailsDAO) {
		this.orderDetailsDAO = orderDetailsDAO;
	}

	@Override
	@Transactional
	public void addOrderDetails(OrderDetails od) {
		this.orderDetailsDAO.addOrderDetails(od);
		
	}

	@Override
	@Transactional
	public void updateOrderDetails(OrderDetails od) {
		this.orderDetailsDAO.updateOrderDetails(od);
		
	}

	@Override
	@Transactional
	public List<OrderDetails> orderDetailsList() {
		return this.orderDetailsDAO.listOrderDetails();
	}

	@Override
	@Transactional
	public OrderDetails getOrderDetailsById(int id) {
		return this.orderDetailsDAO.getOrderDetailsbyId(id);
	}

	@Override
	@Transactional
	public void removeOrderDetails(int id) {
		this.orderDetailsDAO.removeOrderDetails(id);
		
	}

}
