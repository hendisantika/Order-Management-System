package com.hendi.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hendi.oms.model.Product;

public class TextBoxController {
	
	/*public TextBoxController(){
		setCommandClass(Product.class);
		setCommandName("product");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		Product product = (Product)command;
		return new ModelAndView("ProductSuccess","product", product);
	
	}*/
	
	@RequestMapping("/login")
	public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout) {
		String message = "";
		if (authfailed != null) {
			message = "Invalid username of password, try again !";
		} else if (logout != null) {
			message = "Logged Out successfully, login again to continue !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping({"/","index", "/profile"})
	public String getProfilePage() {
		/*return "profile";*/
		return "profile";
	}
	
}