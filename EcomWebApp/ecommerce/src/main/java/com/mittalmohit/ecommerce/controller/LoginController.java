package com.mittalmohit.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.ecommerce.dao.UserDAO;
import com.mittalmohit.ecommerce.pojo.Buyer;
import com.mittalmohit.ecommerce.pojo.Seller;
import com.mittalmohit.ecommerce.pojo.User;



@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value={"login", "seller/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null){
			return "home";
		}
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Buyer authenticatedBuyer = userDAO.authenticateBuyer(username, password);
		if(authenticatedBuyer == null){
			return "error";
		}
		session.setAttribute("user", authenticatedBuyer);
		return "buyer/buyerhome";
	}
	
	
	
	@RequestMapping(value="seller/login", method = RequestMethod.POST)
	public String sellerLogin(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Seller Login");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Seller authenticatedSeller = userDAO.authenticateSeller(username, password);
		if(authenticatedSeller == null){
			return "error";
		}
		session.setAttribute("user", authenticatedSeller);
		return "seller/sellerhome";
	}
	
	@RequestMapping(value={"logout", "seller/logout"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}
	

}
