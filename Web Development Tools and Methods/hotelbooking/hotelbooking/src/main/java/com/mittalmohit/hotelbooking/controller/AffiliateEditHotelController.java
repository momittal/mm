package com.mittalmohit.hotelbooking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/views/affiliateworkflow/edithotel"})
public class AffiliateEditHotelController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.print("Affiliate Edit Hotel Controller");
		return "/affiliateworkflow/edithotel";
	}
	
}
