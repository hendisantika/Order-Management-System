package com.hendi.oms.dao;

import java.util.List;

import com.hendi.oms.model.Product;

public interface ProductDAO {
	public void addProduct(Product p);
    public void updateProduct(Product p);
    public List<Product> listproduct();
    public Product getProductById(int id);
    public void removeProduct(int id);

}
