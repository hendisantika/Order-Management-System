package com.hendi.oms.dao;

import java.util.List;

import com.hendi.oms.model.OrderDetails;

public interface OrderDetailsDAO {
	public void addOrderDetails(OrderDetails od);
	public void updateOrderDetails(OrderDetails od);
	public List<OrderDetails> listOrderDetails();
	public OrderDetails getOrderDetailsbyId(int id);
	public void removeOrderDetails(int id);

}
