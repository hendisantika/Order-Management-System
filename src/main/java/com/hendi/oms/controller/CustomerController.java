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
import com.hendi.oms.service.CustomerService;

@Controller
//@RequestMapping("/customer")
public class CustomerController {
	private CustomerService customerService;
	
	// Controller untuk Customer
		@Autowired(required=true)
		@Qualifier(value="customerService")
		public void setCustomerService(CustomerService cs) {
			this.customerService = cs;
		}
		
//		@RequestMapping(value="/", method = RequestMethod.GET)
//		public String MainMenu(Model model) {
//			model.addAttribute("customer", new Customer());
//			model.addAttribute("listCustomers", this.customerService.listCustomers());
////			return "mainMenu";
//			return "index";
//		}
		
		@RequestMapping(value="/customers", method = RequestMethod.GET)
		public String listCustomers(Model model) {
			model.addAttribute("customer", new Customer());
			model.addAttribute("listCustomers", this.customerService.listCustomers());
			return "customer";
		}
		
		// Untuk add dan update product sekaligus
		@RequestMapping(value="/customer/add", method = RequestMethod.POST)
		public String addCustomer(@ModelAttribute("customer") Customer c) {
			if(c.getCustomerId()== 0){
				// New product, add it.
				this.customerService.addCustomer(c);
			}else{
				// existing product, call update
				this.customerService.updateCustomer(c);
			}
			return "redirect:/customers";
		}
		
		@RequestMapping(value = "/customer/remove/{customerId}")
		public String removeCustomer(@PathVariable("customerId") int id) {
			this.customerService.removeCustomer(id);
			return "redirect:/customers";
		}
		
		@RequestMapping(value="/customer/edit/{customerId}")
		public String editCustomerById(@PathVariable("customerId") int id, Model model) {
			model.addAttribute("customer", this.customerService.getCustomerById(id));
			model.addAttribute("listCustomers", this.customerService.listCustomers());
			return "customer";
		}
		
}
