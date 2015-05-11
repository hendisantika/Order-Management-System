package com.hendi.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hendi.oms.model.OrderDetails;
import com.hendi.oms.service.OrderDetailsService;

@Controller
public class OrderDetailsController {
	   private OrderDetailsService orderDetailsService;
	
	// Controller untuk Order Details
		@Autowired(required=true)
		@Qualifier(value="orderDetailsService")
	   public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
			this.orderDetailsService = orderDetailsService;
		}
		
		@RequestMapping(value="/orderDetails", method = RequestMethod.GET)
		public String listOrderDetails(Model model) {
			model.addAttribute("orderDetails", new OrderDetails());
			model.addAttribute("listOrderDetails", this.orderDetailsService.orderDetailsList());
			return "orderDetails";
		}
		

		// Untuk add dan update product sekaligus
		@RequestMapping(value="/orderDetails/add", method = RequestMethod.POST)
		public String addOrderDetails(@ModelAttribute("orderDetails") OrderDetails od) {
			if(od.getOrderDetailsNo()== 0){
				// New orders, add it.
				this.orderDetailsService.addOrderDetails(od);
			}else{
				// existing product, call update
				this.orderDetailsService.updateOrderDetails(od);
			}
			return "redirect:/orderDetails";
		}
		
		@RequestMapping(value = "/orderDetails/remove/{orderDetailsNo}")
		public String removeOrders(@PathVariable("orderDetailsNo") int id) {
			this.orderDetailsService.removeOrderDetails(id);
			return "redirect:/orders";
		}
		
		@RequestMapping(value="/orderDetails/edit/{orderDetailsNo}")
		public String editOrderDetailsById(@PathVariable("orderDetailsNo") int id, Model model) {
			model.addAttribute("orderDetails", this.orderDetailsService.getOrderDetailsById(id));
			model.addAttribute("listOrderDetails", this.orderDetailsService.orderDetailsList());
			return "orders";
		}
		

}
