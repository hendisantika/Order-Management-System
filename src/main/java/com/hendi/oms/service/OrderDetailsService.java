package com.hendi.oms.service;

import java.util.List;

import com.hendi.oms.model.OrderDetails;

public interface OrderDetailsService {
	public void addOrderDetails(OrderDetails od);
	public void updateOrderDetails(OrderDetails od);
	public List<OrderDetails> orderDetailsList();
	public OrderDetails getOrderDetailsById(int id);
	public void removeOrderDetails(int id);

}
