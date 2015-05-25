package com.hendi.oms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@Column(name="orderID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderID;
	
	//@OneToOne(mappedBy = "orders")
	int customerId;
	//Customer customer;
	
	
	double totalAmount;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString(){
		return "orderID = " + orderID + " , customerId = " + customerId + " , totalAmount = " + totalAmount;
	}

}
