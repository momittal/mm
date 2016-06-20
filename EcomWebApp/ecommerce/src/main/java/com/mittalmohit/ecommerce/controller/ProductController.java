package com.mittalmohit.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mittalmohit.ecommerce.dao.ProductDAO;
import com.mittalmohit.ecommerce.pojo.Product;
import com.mittalmohit.ecommerce.pojo.Seller;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;


	@RequestMapping(value="seller/addproduct", method=RequestMethod.GET)
	public String addProductGet(HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null){
			return "seller/addproduct";	
		}
		return "error";
	}

	@RequestMapping(value="seller/addproduct", method=RequestMethod.POST)
	public String addProductPost(HttpServletRequest request){
		HttpSession session = request.getSession();

		if (session.getAttribute("user") != null){
			Seller seller = (Seller) session.getAttribute("user");
			String productTitle = request.getParameter("title");
			String category = request.getParameter("category");
			String description = request.getParameter("description");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			double price = Double.parseDouble(request.getParameter("price"));
			Product addedProduct = productDAO.addProducts(productTitle, category, description, quantity, price, seller);
			request.setAttribute("addedProduct", addedProduct);
			return "seller/productadded";	
		}else{
			return "error";
		}	
	}
	
	@RequestMapping(value="seller/viewproducts", method=RequestMethod.GET)
	public String viewProduct(HttpServletRequest request){
		HttpSession session = request.getSession();

		if (session.getAttribute("user") != null){
			Seller seller = (Seller) session.getAttribute("user");
			List<Product> products= productDAO.viewProducts(seller);	
			request.setAttribute("products", products);
			return "seller/viewproducts";
		}else{
			return "error";
		}
			
	}

}