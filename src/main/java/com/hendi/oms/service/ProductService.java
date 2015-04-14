package com.hendi.oms.service;

import java.util.List;

import com.hendi.oms.model.Product;

public interface ProductService {
	public void addProduct(Product p);
	public void updateProduct(Product p);
	public List<Product> listProduct();
	public Product getProductbyId(int id);
	public void removeProduct(int id);

}
