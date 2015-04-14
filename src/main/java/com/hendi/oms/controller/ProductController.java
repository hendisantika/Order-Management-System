 package com.hendi.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hendi.oms.model.Customer;
import com.hendi.oms.model.Product;
import com.hendi.oms.service.CustomerService;
import com.hendi.oms.service.ProductService;


@Controller
public class ProductController {
	private ProductService productService;
	private CustomerService customerService;
	
	// Controller untuk Product
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setProductService(ProductService ps) {
		this.productService = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService cs) {
		this.customerService = cs;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String MainMenu(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("customer", new Customer());
		model.addAttribute("listProducts", this.productService.listProduct());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
//		return "mainMenu";
		return "index";
	}
	
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProduct());
		return "product";
//		return "mainMenu";
	}
	
	// Untuk add dan update product sekaligus
	@RequestMapping(value="/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product p) {
		if(p.getProductId()== 0){
			// New product, add it.
			this.productService.addProduct(p);
		}else{
			// existing product, call update
			this.productService.updateProduct(p);
		}
		return "redirect:/products";
	}

	@RequestMapping(value = "/remove/{productId}")
	public String removeProduct(@PathVariable("productId") int id) {
		this.productService.removeProduct(id);
		return "redirect:/products";
	}
	
	@RequestMapping(value="/edit/{productId}")
	public String editProductbyId(@PathVariable("productId") int id, Model model) {
		model.addAttribute("product", this.productService.getProductbyId(id));
		model.addAttribute("listProducts", this.productService.listProduct());
		return "product";
	}

}
