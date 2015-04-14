package com.hendi.oms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hendi.oms.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Product saved successfully, Product Details = "+p);
		
	}

	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Product updated successfully, Product Details = "+p);
		
	}

	@SuppressWarnings("unchecked")
	public List<Product> listproduct() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList = session.createQuery("from Product").list();
		for(Product p : productList){
			logger.info("Product List :: " +p);
		}
		return productList;
	}

	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded succesfully, Product details = "+p);
		return p;
	}

	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Product deleted succesfully, product details = " +p);
		
	}


}
