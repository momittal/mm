package com.mittalmohit.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.ecommerce.dao.UserDAO;
import com.mittalmohit.ecommerce.pojo.Buyer;
import com.mittalmohit.ecommerce.pojo.Seller;
import com.mittalmohit.ecommerce.validator.UserValidator;

@Controller
public class RegistrationController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = {"registration", "seller/registration"}, method=RequestMethod.GET)
	public String registration(HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null){
			return "home";
		}
		return "registration";
	}
	
	@RequestMapping(value = {"registration"}, method=RequestMethod.POST)
	public String doSubmitUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zipcode= request.getParameter("zipcode");
		String phone =request.getParameter("phone");
		
		
		UserValidator.validateInputs(username, password, name, email, addressLine1, addressLine2, city, state, country, zipcode, phone);
		
		userDAO.registerBuyer(username, password, name, email, addressLine1, addressLine2, city, state, country, zipcode, phone);	
		
		
		
		return "registration";
	}
	
	@RequestMapping(value = {"seller/registration"}, method=RequestMethod.POST)
	public String doSubmitSeller(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zipcode= request.getParameter("zipcode");
		String phone =request.getParameter("phone");
		
		
		UserValidator.validateInputs(username, password, name, email, addressLine1, addressLine2, city, state, country, zipcode, phone);
		
		userDAO.registerSeller(username, password, name, email, addressLine1, addressLine2, city, state, country, zipcode, phone);	
		
		
		
		return "registration";
	}
	
	
	
	

	
	
	
}
