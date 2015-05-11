package com.hendi.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hendi.oms.model.Orders;
import com.hendi.oms.service.OrdersService;

@Controller
public class OrdersController {
		private OrdersService ordersService;
	
	// Controller untuk Orders
		@Autowired(required=true)
		@Qualifier(value="ordersService")
		public void setOrdersService(OrdersService os) {
			this.ordersService = os;
		}
		
//		@RequestMapping(value="/", method = RequestMethod.GET)
//		public String MainMenu(Model model) {
//			model.addAttribute("customer", new Customer());
//			model.addAttribute("listCustomers", this.customerService.listCustomers());
////			return "mainMenu";
//			return "index";
//		}
		
		@RequestMapping(value="/orders", method = RequestMethod.GET)
		public String listOrders(Model model) {
			model.addAttribute("orders", new Orders());
			model.addAttribute("listOrders", this.ordersService.listOrders());
			
//			Map<String, Object> models = new HashMap<String, Object>();
//	        models.put("orders", ordersService.listCustomer());
//	        return new ModelAndView("orders", "models", models);
			
			return "orders";
		}
		
		// Untuk add dan update product sekaligus
		@RequestMapping(value="/orders/add", method = RequestMethod.POST)
		public String addOrders(@ModelAttribute("order") Orders o) {
			if(o.getOrderID()== 0){
				// New orders, add it.
				this.ordersService.addOrders(o);
			}else{
				// existing product, call update
				this.ordersService.updateOrders(o);
			}
			return "redirect:/orders";
		}
		
		@RequestMapping(value = "/orders/remove/{orderId}")
		public String removeOrders(@PathVariable("orderId") int id) {
			this.ordersService.removeOrders(id);
			return "redirect:/orders";
		}
		
		@RequestMapping(value="/orders/edit/{orderId}")
		public String editOrdersById(@PathVariable("orderId") int id, Model model) {
			model.addAttribute("order", this.ordersService.getOrdersById(id));
			model.addAttribute("listOrders", this.ordersService.listOrders());
			return "orders";
		}
		
		
		

}
