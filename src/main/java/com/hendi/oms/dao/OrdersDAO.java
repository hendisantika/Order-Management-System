package com.hendi.oms.dao;

import java.util.List;

import com.hendi.oms.model.Orders;

public interface OrdersDAO {
	public void addOrders(Orders o);
	public void updateOrders(Orders o);
	public List<Orders> listOrders();
	public List<Orders> getCustomername();
	public Orders getOrdersById(int id);
	public void removeOrders(int id);
	
}
