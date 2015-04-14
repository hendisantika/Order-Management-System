package com.hendi.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hendi.oms.dao.OrdersDAO;
import com.hendi.oms.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersDAO ordersDAO;
	
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	@Override
	@Transactional
	public void addOrders(Orders o) {
		this.ordersDAO.addOrders(o);
		
	}

	@Override
	@Transactional
	public void updateOrders(Orders o) {
		this.ordersDAO.updateOrders(o);
		
	}

	@Override
	@Transactional
	public List<Orders> listOrders() {
		return this.ordersDAO.listOrders();
		
	}

	@Override
	@Transactional
	public Orders getOrdersById(int id) {
		return this.ordersDAO.getOrdersById(id);
	}

	@Override
	@Transactional
	public void removeOrders(int id) {
		this.ordersDAO.removeOrders(id);
		
	}
	

}
