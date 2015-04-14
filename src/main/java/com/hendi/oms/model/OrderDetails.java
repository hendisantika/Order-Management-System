package com.hendi.oms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class OrderDetails {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderDetailsNo;
	int orderID;
	int productId;
	int quantity;
	double subtotal;
	
	public int getOrderDetailsNo() {
		return orderDetailsNo;
	}
	public void setOrderDetailsNo(int orderDetailsNo) {
		this.orderDetailsNo = orderDetailsNo;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	@Override
	public String toString(){
		return "orderDetailsNo = " + orderDetailsNo + " , orderID = " + orderID + " , productId = " + productId
				+ " , quantity = " + quantity + " , subtotal = " + subtotal;
	}
	

}
