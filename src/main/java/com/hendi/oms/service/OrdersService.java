package com.hendi.oms.service;

import java.util.List;

import com.hendi.oms.model.Orders;

public interface OrdersService {
	public void addOrders(Orders o);
	public void updateOrders(Orders o);
	public List<Orders> listOrders();
	public Orders getOrdersById(int id);
	public void removeOrders(int id);

}
