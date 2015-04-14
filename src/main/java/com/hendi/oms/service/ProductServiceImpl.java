package com.hendi.oms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hendi.oms.dao.ProductDAO;
import com.hendi.oms.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO;
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Transactional
	public void addProduct(Product p) {
		this.productDAO.addProduct(p);
		
	}

	@Transactional
	public void updateProduct(Product p) {
		this.productDAO.updateProduct(p);
		
	}

	@Transactional
	public List<Product> listProduct() {
		return this.productDAO.listproduct();
	}

	@Transactional
	public Product getProductbyId(int id) {
		return this.productDAO.getProductById(id);
	}

	@Transactional
	public void removeProduct(int id) {
		this.productDAO.removeProduct(id);
	}

}
